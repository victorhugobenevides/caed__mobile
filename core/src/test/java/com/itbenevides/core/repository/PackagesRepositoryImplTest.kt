package com.itbenevides.core.repository

import com.itbenevides.core.data.model.Packages
import com.itbenevides.core.data.remote.APIService
import com.itbenevides.core.domain.repository.PackagesRepositoryImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import retrofit2.HttpException

class PackagesRepositoryImplTest {

    private lateinit var apiService: APIService
    private lateinit var packagesRepository: PackagesRepositoryImpl
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        apiService = mock()
        packagesRepository = PackagesRepositoryImpl(apiService)
    }

    @Test
    fun `getPackages returns expected packages`() = runTest(testDispatcher) {
        // Configuração
        val expectedPackages = mock<Packages>()
        whenever(apiService.getPackages()).thenReturn(expectedPackages)

        // Execução
        val result = packagesRepository.getPackages()

        // Verificação
        assertEquals(expectedPackages, result)
    }

    @Test
    fun `getPackages throws HttpException`() = runTest(testDispatcher) {
        // Configuração
        val httpException = HttpException(mock())

        // Simulando HttpException
        whenever(apiService.getPackages()).thenThrow(httpException)

        // Execução e Verificação
        val exception = assertThrows(HttpException::class.java) {
            runBlocking { packagesRepository.getPackages() }
        }

        assertEquals(httpException, exception)
    }

    @Test
    fun `getPackages throws RuntimeException`() = runTest(testDispatcher) {
        // Configuração
        val runtimeException = RuntimeException("Erro de conexão")

        // Simulando RuntimeException
        whenever(apiService.getPackages()).thenThrow(runtimeException)

        // Execução e Verificação
        val exception = assertThrows(RuntimeException::class.java) {
            runBlocking { packagesRepository.getPackages() }
        }

        assertEquals("Erro de conexão", exception.message)
    }
}
