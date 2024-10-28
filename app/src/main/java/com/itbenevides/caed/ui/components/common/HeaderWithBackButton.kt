package com.itbenevides.caed.ui.components.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.itbenevides.caed.theme.Black
import com.itbenevides.caed.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderWithBackButton(title: String, onBackClick: () -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = White,
            titleContentColor = Black,
            navigationIconContentColor = Black
        ),
        title = { Text(title) },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
        }
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHeaderWithBackButton() {
    HeaderWithBackButton("Título da Tela") {

    }
}
