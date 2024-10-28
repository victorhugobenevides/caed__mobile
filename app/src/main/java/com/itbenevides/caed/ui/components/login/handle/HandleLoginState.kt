package com.itbenevides.caed.ui.components.login.handle

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.itbenevides.caed.ui.components.common.AlertDialogError
import com.itbenevides.caed.ui.components.common.LoadingView
import com.itbenevides.caed.ui.feature.login.state.LoginState
import com.itbenevides.caed.navigation.AppRoutes

@Composable
fun HandleLoginState(loginState: LoginState, navController: NavHostController?, screen: AppRoutes) {

    when (loginState) {
        is LoginState.Loading -> {
            LoadingView()
        }

        is LoginState.Error -> {
            val errorMessage = loginState.message
            AlertDialogError(message = errorMessage)
        }

        is LoginState.Success -> {
            LaunchedEffect(screen.route) {
                navController?.navigate(screen.route)
            }

        }

        else -> Unit
    }
}