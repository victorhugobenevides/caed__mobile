package com.itbenevides.core.usecase

import com.itbenevides.core.data.model.Packages
import com.itbenevides.core.data.repository.PackagesRepository
import com.itbenevides.core.domain.usecase.PackagesUseCaseImp
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import retrofit2.HttpException
import java.io.IOException

class PackagesUseCaseImpTest {

    private lateinit var packagesRepository: PackagesRepository
    private lateinit var packagesUseCase: PackagesUseCaseImp
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        packagesRepository = mock()
        packagesUseCase = PackagesUseCaseImp(packagesRepository)
    }

    @Test
    fun `getPackages returns expected packages`() = runTest(testDispatcher) {
        // Configuração
        val expectedPackages = mock<Packages>()
        whenever(packagesRepository.getPackages()).thenReturn(expectedPackages)

        // Execução
        val result = packagesUseCase.getPackages()

         // Verificação
        assertTrue(result.isSuccess)
        assertEquals(expectedPackages, result.getOrNull())
        verify(packagesRepository).getPackages()
    }

    @Test
    fun `getPackages with HttpException returns failure`() = runTest(testDispatcher) {
        // Configuração
        val httpException = mock<HttpException>()
        whenever(packagesRepository.getPackages()).thenThrow(httpException)

        // Execução
        val result = packagesUseCase.getPackages()

         // Verificação
        assertTrue(result.isFailure)
        assertEquals("Erro de servidor. Tente novamente.", result.exceptionOrNull()?.message)
        verify(packagesRepository).getPackages()
    }

    @Test
    fun `getPackages with IOException returns connection error`() = runTest(testDispatcher) {
        // Configuração
        whenever(packagesRepository.getPackages()).doAnswer { throw IOException() }

        // Execução
        val result = packagesUseCase.getPackages()

         // Verificação
        assertTrue(result.isFailure)
        assertEquals("Erro de conexão. Verifique sua internet.", result.exceptionOrNull()?.message)
        verify(packagesRepository).getPackages()
    }

    @Test
    fun `getPackages with unknown error returns failure`() = runTest(testDispatcher) {
        // Configuração
        whenever(packagesRepository.getPackages()).thenThrow(RuntimeException("Unexpected error"))

        // Execução
        val result = packagesUseCase.getPackages()

         // Verificação
        assertTrue(result.isFailure)
        assertEquals("Erro desconhecido. Tente novamente.", result.exceptionOrNull()?.message)
        verify(packagesRepository).getPackages()
    }
}
