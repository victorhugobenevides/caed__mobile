import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.itbenevides.caed.ui.feature.login.state.LoginState
import com.itbenevides.caed.ui.feature.login.viewmodel.LoginViewModel
import com.itbenevides.core.data.model.ResponseLogin
import com.itbenevides.core.data.model.User
import com.itbenevides.core.domain.usecase.di.LoginUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var loginUseCase: LoginUseCase
    private lateinit var loginViewModel: LoginViewModel
    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Before
    fun setup() {
        loginUseCase = mock()
        loginViewModel = LoginViewModel(loginUseCase)
        kotlinx.coroutines.Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        kotlinx.coroutines.Dispatchers.resetMain()
    }

    @Test
    fun `login success updates state to Success`() = testScope.runTest {
        // Configuração
        val user = User("username", "password")
        whenever(loginUseCase.login(user)).thenReturn(Result.success(ResponseLogin(true)))

        // Execução
        loginViewModel.login(user.name, user.password)
        advanceUntilIdle()

        // Verificação
        val state = loginViewModel.loginState.first()
        assertEquals(LoginState.Success, state)
    }

    @Test
    fun `login with invalid credentials updates state to Error`() = testScope.runTest {
        // Configuração
        val user = User("username", "password")
        val errorMessage = "Login ou senha incorretos."
        whenever(loginUseCase.login(user)).thenReturn(Result.failure(Exception(errorMessage)))

        // Execução
        loginViewModel.login(user.name, user.password)
        advanceUntilIdle()

        // Verificação
        val state = loginViewModel.loginState.first()
        assertEquals(LoginState.Error(errorMessage), state)
    }

    @Test
    fun `login with connection error updates state to Error`() = testScope.runTest {
        // Configuração
        val user = User("username", "password")
        val errorMessage = "Erro de conexão. Verifique sua internet."
        whenever(loginUseCase.login(user)).thenReturn(Result.failure(Exception(errorMessage)))

        // Execução
        loginViewModel.login(user.name, user.password)
        advanceUntilIdle()

        // Verificação
        val state = loginViewModel.loginState.first()
        assertEquals(LoginState.Error(errorMessage), state)
    }

    @Test
    fun `login with unknown error updates state to Error`() = testScope.runTest {
        // Configuração
        val user = User("username", "password")
        val errorMessage = "Erro desconhecido."
        whenever(loginUseCase.login(user)).thenReturn(Result.failure(Exception(errorMessage)))

        // Execução
        loginViewModel.login(user.name, user.password)
        advanceUntilIdle()

        // Verificação
        val state = loginViewModel.loginState.first()
        assertEquals(LoginState.Error(errorMessage), state)
    }
}
