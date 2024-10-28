package com.itbenevides.caed.ui.components.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itbenevides.caed.ui.components.common.TextInputField

@Composable
fun LoginForm(
    username: String,
    password: String,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
) {

    var usernameError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        TextInputField(
            label = "Usuário",
            value = username,
            onValueChange = {
                onUsernameChange(it)
                usernameError = if (it.isEmpty()) {
                    "Usuário não pode ser vazio."
                } else {
                    ""
                }
            },
            errorMessage = usernameError,
            modifier = Modifier.testTag("usernameInput")
        )
        TextInputField(
            label = "Senha",
            value = password,
            onValueChange = {
                onPasswordChange(it)
                passwordError = if (it.isEmpty()) {
                    "Senha não pode ser vazia."
                } else {
                    ""
                }
            },
            isPassword = true,
            errorMessage = passwordError,
            modifier = Modifier.testTag("passwordInput")
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoginForm() {
    LoginForm(
        username = "",
        password = "",
        onUsernameChange = {},
        onPasswordChange = {},
    )
}