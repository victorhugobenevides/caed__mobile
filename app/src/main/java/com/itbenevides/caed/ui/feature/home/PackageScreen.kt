import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavArgument
import androidx.navigation.NavHostController
import com.itbenevides.caed.ui.components.common.BottomNavigationMenu
import com.itbenevides.caed.ui.components.common.HeaderWithBackButton
import com.itbenevides.caed.ui.components.packages.handle.HandlerPackageState
import com.itbenevides.caed.ui.components.packages.menu.TabMenu
import com.itbenevides.caed.ui.components.packages.menu.TabScreen
import com.itbenevides.caed.ui.components.packages.detail.PackageDetails
import com.itbenevides.caed.ui.components.packages.itemlist.PackageListWithHeader
import com.itbenevides.caed.ui.components.packages.resume.HorizontalListPackageResumeCard
import com.itbenevides.caed.ui.components.packages.status.StatusTimeline
import com.itbenevides.caed.ui.feature.home.viewmodel.PackagesViewModel
import com.itbenevides.caed.navigation.AppRoutes
import com.itbenevides.caed.theme.White
import com.itbenevides.core.data.model.Packages
import com.itbenevides.core.data.model.getMockPackages

@Composable
fun PackageScreen(
    navController: NavHostController?,
    viewModel: PackagesViewModel = hiltViewModel()
) {
    val packagesState by viewModel.packagesState.collectAsState()

    HandlerPackageState(packagesState, navController)
}


@Composable
fun PackageScreen(navController: NavHostController?, packages: Packages) {
    val tabTitles = listOf(TabScreen.PACKAGE, TabScreen.STATUS, TabScreen.DATA)

    var selectedTab by remember { mutableStateOf(TabScreen.PACKAGE) }

    Scaffold(
        contentColor = White,
        containerColor = White,
        bottomBar = { BottomNavigationMenu() },
        topBar = {
            HeaderWithBackButton("Listagem de pacotes") {}
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues),
        ) {
            HorizontalListPackageResumeCard(packages = packages.resumePackages)
            TabMenu(tabTitles = tabTitles) {
                selectedTab = it
            }
            LazyColumn(
                modifier = Modifier.padding(16.dp)
            ){
                item {
                    when (selectedTab) {
                        TabScreen.PACKAGE -> {
                            PackageListWithHeader(packages = packages.packages) {
                                val navArgument = NavArgument.Builder().setDefaultValue(it).build()
                                navController?.graph?.addArgument("packageDetails", navArgument)
                                navController?.navigate(AppRoutes.Details.route)
                            }
                        }

                        TabScreen.STATUS -> {
                            StatusTimeline(statusList = packages.status)
                        }

                        TabScreen.DATA -> {
                            PackageDetails(packageItem = packages.packageGroup)
                        }
                    }
                }
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPackageScreen() {
    val packages = getMockPackages()
    PackageScreen(null, packages = packages)
}
