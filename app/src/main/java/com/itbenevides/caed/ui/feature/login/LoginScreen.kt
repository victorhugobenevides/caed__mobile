package com.itbenevides.caed.ui.feature.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.itbenevides.caed.ui.components.common.PrimaryButton
import com.itbenevides.caed.ui.components.login.handle.HandleLoginState
import com.itbenevides.caed.ui.components.login.LoginForm
import com.itbenevides.caed.ui.components.login.LogoImage
import com.itbenevides.caed.ui.components.login.TopImage
import com.itbenevides.caed.ui.feature.login.viewmodel.LoginViewModel
import com.itbenevides.caed.navigation.AppRoutes

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LoginScreen(
    navController: NavHostController?, viewModel: LoginViewModel = hiltViewModel()
) {
    val loginState by viewModel.loginState.collectAsState()

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    LaunchedEffect(scrollState.maxValue) {
        scrollState.animateScrollTo(scrollState.maxValue)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
            .navigationBarsPadding()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .imeNestedScroll()
            ) {
                TopImage()
                LogoImage()
                Spacer(modifier = Modifier.height(32.dp))
                LoginForm(username = username,
                    password = password,
                    onUsernameChange = { username = it },
                    onPasswordChange = { password = it })
                Spacer(modifier = Modifier.height(52.dp))
            }
        }

        PrimaryButton(
            text = "Entrar", enabled = true, onClick = {
                viewModel.login(name = username, password = password)
            }, modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd)
                .size(60.dp)
                .testTag("buttomLogin")
        )
    }

    HandleLoginState(loginState, navController, AppRoutes.Home)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen(navController = null)
}
