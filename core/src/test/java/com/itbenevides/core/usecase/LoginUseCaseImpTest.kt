package com.itbenevides.core.usecase

import com.itbenevides.core.data.model.ResponseLogin
import com.itbenevides.core.data.model.User
import com.itbenevides.core.data.repository.LoginRepository
import com.itbenevides.core.domain.usecase.LoginUseCaseImp
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import retrofit2.HttpException
import java.io.IOException

class LoginUseCaseImpTest {

    private lateinit var loginRepository: LoginRepository
    private lateinit var loginUseCase: LoginUseCaseImp
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        loginRepository = mock()
        loginUseCase = LoginUseCaseImp(loginRepository)
    }

    @Test
    fun `login with valid credentials returns success`() = runTest(testDispatcher) {
        // Configuração
        val user = User("username", "password")
        val expectedResponse = mock<ResponseLogin>()
        whenever(loginRepository.login(user)).thenReturn(expectedResponse)

        // Execução
        val result = loginUseCase.login(user)

        // Verificação
        assertTrue(result.isSuccess)
        assertEquals(expectedResponse, result.getOrNull())
        verify(loginRepository).login(user)
    }

    @Test
    fun `login with HttpException 401 returns invalid credentials error`() =
        runTest(testDispatcher) {
            // Configuração
            val user = User("username", "wrong_password")
            val httpException = mock<HttpException> {
                on { code() }.thenReturn(401)
            }
            whenever(loginRepository.login(user)).thenThrow(httpException)

            // Execução
            val result = loginUseCase.login(user)

            // Verificação
            assertTrue(result.isFailure)
            assertEquals("Login ou senha incorretos.", result.exceptionOrNull()?.message)
            verify(loginRepository).login(user)
        }

    @Test
    fun `login with HttpException returns server error`() = runTest(testDispatcher) {
        // Configuração
        val user = User("username", "password")
        val httpException = mock<HttpException> {
            on { code() }.thenReturn(500)
        }
        whenever(loginRepository.login(user)).thenThrow(httpException)

        // Execução
        val result = loginUseCase.login(user)

        // Verificação
        assertTrue(result.isFailure)
        assertEquals("Erro de servidor. Tente novamente.", result.exceptionOrNull()?.message)
        verify(loginRepository).login(user)
    }

    @Test
    fun `login with IOException returns connection error`() = runTest(testDispatcher) {
        // Configuração
        val user = User("username", "password")
        whenever(loginRepository.login(user)).thenAnswer { throw IOException() }

        // Execução
        val result = loginUseCase.login(user)

        // Verificação
        assertTrue(result.isFailure)
        assertEquals("Erro de conexão. Verifique sua internet.", result.exceptionOrNull()?.message)
        verify(loginRepository).login(user)
    }

    @Test
    fun `login with unknown error returns failure`() = runTest(testDispatcher) {
        // Configuração
        val user = User("username", "password")
        whenever(loginRepository.login(user)).thenThrow(RuntimeException("Unexpected error"))

        // Execução
        val result = loginUseCase.login(user)

        // Verificação
        assertTrue(result.isFailure)
        assertEquals("Erro desconhecido. Tente novamente.", result.exceptionOrNull()?.message)
        verify(loginRepository).login(user)
    }
}
