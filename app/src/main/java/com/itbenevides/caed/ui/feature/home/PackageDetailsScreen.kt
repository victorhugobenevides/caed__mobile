import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.itbenevides.caed.ui.components.common.BottomNavigationMenu
import com.itbenevides.caed.ui.components.common.HeaderWithBackButton
import com.itbenevides.caed.ui.components.packages.menu.TabMenu
import com.itbenevides.caed.ui.components.packages.menu.TabScreen
import com.itbenevides.caed.ui.components.packages.detail.PackageDetails
import com.itbenevides.caed.ui.components.packages.status.StatusTimeline
import com.itbenevides.caed.navigation.AppRoutes
import com.itbenevides.caed.theme.White
import com.itbenevides.core.data.model.Package
import com.itbenevides.core.data.model.getMockPackages


@Composable
fun PackageDetailsScreen(navController: NavHostController?, packages: Package) {
    val tabTitles = listOf(TabScreen.STATUS, TabScreen.DATA)
    var selectedTab by remember { mutableStateOf(TabScreen.STATUS) }

    Scaffold(
        containerColor = White,
        bottomBar = { BottomNavigationMenu() },
        topBar = {
            HeaderWithBackButton("Pacote ${packages.code}") {
                navController?.navigate(AppRoutes.Home.route)
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .background(White)
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                TabMenu(tabTitles = tabTitles) {
                    selectedTab = it
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    when (selectedTab) {
                        TabScreen.STATUS -> {
                            StatusTimeline(statusList = packages.status)
                        }

                        TabScreen.DATA -> {
                            PackageDetails(packageItem = packages)
                        }

                        else -> {}
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPackageDetailsScreen() {
    val packages = getMockPackages()
    PackageDetailsScreen(null, packages = packages.packageGroup)
}
