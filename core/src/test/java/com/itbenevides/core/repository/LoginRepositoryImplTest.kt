import com.itbenevides.core.data.model.ResponseLogin
import com.itbenevides.core.data.model.User
import com.itbenevides.core.data.remote.APIService
import com.itbenevides.core.data.repository.LoginRepositoryImpl
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.kotlin.mock
import retrofit2.HttpException

class LoginRepositoryImplTest {

    private lateinit var apiService: APIService
    private lateinit var loginRepository: LoginRepositoryImpl
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        apiService = mock()
        loginRepository = LoginRepositoryImpl(apiService)
    }

    @Test
    fun `login returns successful response`() = runTest(testDispatcher) {
        // Configuração
        val user = User("username", "password")
        val expectedResponse = ResponseLogin(true)
        `when`(apiService.login(user)).thenReturn(expectedResponse)

        // Execução
        val result = loginRepository.login(user)

        // Verificação
        assertEquals(expectedResponse, result)
    }

    @Test
    fun `login throws IOException as RuntimeException`() = runTest(testDispatcher) {
        // Configuração
        val user = User("username", "password")
        val runtimeException = RuntimeException("Erro de conexão")
        `when`(apiService.login(user)).thenThrow(runtimeException)

        // Execução
        try {
            loginRepository.login(user)
            fail("Deveria ter lançado RuntimeException")
        } catch (e: RuntimeException) {
            // Verificação
            assertEquals("Erro de conexão", e.message)
        }
    }

    @Test
    fun `login throws HttpException`() = runTest(testDispatcher) {
        // Configuração
        val user = User("username", "password")
        val httpException = mock<HttpException> {
            on { code() }.thenReturn(401)
        }
        `when`(apiService.login(user)).thenThrow(httpException)

        // Execução
        try {
            loginRepository.login(user)
            fail("Deveria ter lançado HttpException")
        } catch (e: HttpException) {
            // Verificação
            assertEquals(401, e.code())
        }
    }
}
