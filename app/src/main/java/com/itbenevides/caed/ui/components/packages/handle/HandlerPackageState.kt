package com.itbenevides.caed.ui.components.packages.handle

import PackageScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.itbenevides.caed.ui.components.common.AlertDialogError
import com.itbenevides.caed.ui.components.common.LoadingView
import com.itbenevides.caed.ui.feature.home.state.PackagesState

@Composable
fun HandlerPackageState(
    packgagesState: PackagesState,
    navController: NavHostController?
) {

    when (packgagesState) {
        is PackagesState.Loading -> {
            LoadingView()
        }

        is PackagesState.Error -> {
            val errorMessage = packgagesState.message
            AlertDialogError(message = errorMessage)
        }

        is PackagesState.Success -> {
            val packages = packgagesState.packages
            PackageScreen(navController = navController, packages = packages)
        }

        else -> Unit
    }
}