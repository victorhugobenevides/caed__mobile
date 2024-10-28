import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.itbenevides.caed.ui.feature.home.state.PackagesState
import com.itbenevides.caed.ui.feature.home.viewmodel.PackagesViewModel
import com.itbenevides.core.data.model.Packages
import com.itbenevides.core.domain.usecase.di.PackagesUseCase
import kotlinx.coroutines.Dispatchers
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
class PackagesViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var packagesUseCase: PackagesUseCase
    private lateinit var packagesViewModel: PackagesViewModel
    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Before
    fun setup() {
        packagesUseCase = mock()
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getPackages returns success state`() = testScope.runTest {
        // Configuração
        val expectedPackages = mock<Packages>()
        whenever(packagesUseCase.getPackages()).thenReturn(Result.success(expectedPackages))

        // Execução
        packagesViewModel = PackagesViewModel(packagesUseCase)
        advanceUntilIdle()

        // Verificação
        val state = packagesViewModel.packagesState.first()
        assertEquals(PackagesState.Success(expectedPackages), state)
    }

    @Test
    fun `getPackages returns connection error state`() = testScope.runTest {
        // Configuração
        val errorMessage = "Erro de conexão. Verifique sua internet."
        whenever(packagesUseCase.getPackages()).thenReturn(Result.failure(Exception(errorMessage)))

        // Execução
        packagesViewModel = PackagesViewModel(packagesUseCase)
        advanceUntilIdle()

        // Verificação
        val state = packagesViewModel.packagesState.first()
        assertEquals(PackagesState.Error(errorMessage), state)
    }

    @Test
    fun `getPackages returns server error state`() = testScope.runTest {
        // Configuração
        val errorMessage = "Erro de servidor. Tente novamente."
        whenever(packagesUseCase.getPackages()).thenReturn(Result.failure(Exception(errorMessage)))

        // Execução
        packagesViewModel = PackagesViewModel(packagesUseCase)
        advanceUntilIdle()

        // Verificação
        val state = packagesViewModel.packagesState.first()
        assertEquals(PackagesState.Error(errorMessage), state)
    }

    @Test
    fun `getPackages returns unknown error state`() = testScope.runTest {
        // Configuração
        val errorMessage = "Erro desconhecido."
        whenever(packagesUseCase.getPackages()).thenReturn(Result.failure(Exception(errorMessage)))

        // Execução
        packagesViewModel = PackagesViewModel(packagesUseCase)
        advanceUntilIdle()

        // Verificação
        val state = packagesViewModel.packagesState.first()
        assertEquals(PackagesState.Error(errorMessage), state)
    }
}
