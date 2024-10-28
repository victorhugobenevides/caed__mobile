package com.itbenevides.caed

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.itbenevides.caed.ui.activity.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testInitialState() {
        // Verifica se os componentes iniciais estão presentes
        composeTestRule.onNodeWithTag("usernameInput").assertExists()
        composeTestRule.onNodeWithTag("passwordInput").assertExists()
        composeTestRule.onNodeWithTag("buttomLogin").assertExists()
    }

    @Test
    fun testUsernameAndPasswordInput() {
        val testUsername = "testUser"
        val testPassword = "testPassword"

        // Insere o nome de usuário
        composeTestRule.onNodeWithTag("usernameInput")
            .performTextInput(testUsername)

        // Verifica se o texto foi inserido no campo de usuário
        composeTestRule.onNodeWithTag("usernameInput")
            .assertTextContains(testUsername)

        // Insere a senha
        composeTestRule.onNodeWithTag("passwordInput")
            .performTextInput(testPassword)

        // Verifica se o campo de senha está preenchido (mas sem verificar o texto)
        composeTestRule.onNodeWithTag("passwordInput")
            .assert(hasText("••••••••••••")) // Ou qualquer símbolo de máscara usado
    }


    @Test
    fun testLoginButtonClick() {
        // Insere texto válido nos campos
        composeTestRule.onNodeWithTag("usernameInput")
            .performTextInput("testUser")

        composeTestRule.onNodeWithTag("passwordInput")
            .performTextInput("testPassword")

        // Verifica se o botão está habilitado
        composeTestRule.onNodeWithTag("buttomLogin").assertIsEnabled()

        // Realiza o clique no botão de login
        composeTestRule.onNodeWithTag("buttomLogin").performClick()

        // Verifica a navegação ou outros efeitos após o clique (ajuste conforme necessário)
    }
}
