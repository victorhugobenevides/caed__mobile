package com.itbenevides.caed.navigation

import PackageDetailsScreen
import PackageScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.itbenevides.caed.ui.feature.login.LoginScreen
import com.itbenevides.core.data.model.Package

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppRoutes.Login.route) {
        composable(AppRoutes.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(AppRoutes.Home.route) {
            PackageScreen(navController)
        }
        composable(AppRoutes.Details.route) {
            val packages = navController.graph.arguments["packageDetails"]?.defaultValue as Package
            PackageDetailsScreen(navController = navController, packages = packages)
        }
    }
}
