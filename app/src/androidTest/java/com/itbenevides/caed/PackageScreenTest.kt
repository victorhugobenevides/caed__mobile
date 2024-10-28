package com.itbenevides.caed

import PackageScreen
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToNode
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.itbenevides.core.data.model.getMockPackages
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PackageScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testDefaultTabIsPackage() {
        val packages = getMockPackages()

        composeTestRule.setContent {
            PackageScreen(navController = null, packages = packages)
        }

        composeTestRule
            .onNodeWithText("PACOTES", ignoreCase = true, useUnmergedTree = true)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun testSwitchingTabs() {
        val packages = getMockPackages()

        composeTestRule.setContent {
            PackageScreen(navController = null, packages = packages)
        }

        // Clicar na aba de STATUS
        composeTestRule.onNodeWithText("STATUS", ignoreCase = true, useUnmergedTree = true)
            .assertExists()
            .performClick()

        composeTestRule.onNodeWithText("Status da caixa").assertIsDisplayed()

        // Clicar na aba de DADOS
        composeTestRule.onNodeWithText("DADOS", ignoreCase = true, useUnmergedTree = true)
            .assertExists()
            .performClick()

        composeTestRule.onNodeWithText("Dados da caixa").assertIsDisplayed()


        // Clicar na aba de PACOTES
        composeTestRule.onNodeWithText("PACOTES", ignoreCase = true, useUnmergedTree = true)
            .assertExists()
            .performClick()

        composeTestRule.onNodeWithText("Lista de pacotes").assertIsDisplayed()
    }


    @Test
    fun testScrollToLastItem() {

        val packages = getMockPackages()

        composeTestRule.setContent {
            PackageScreen(navController = null, packages = packages)
        }

        // Assume que o último item tem o texto "Pacote 100"
        val lastItemText = packages.resumePackages.last().label

        // Encontra a lista que queremos rolar
        composeTestRule.onNodeWithTag("PackageList")
            .performScrollToNode(hasText(lastItemText))

        // Verifica se o item é visível após o scroll
        composeTestRule.onNodeWithText(lastItemText).assertIsDisplayed()
    }

}
