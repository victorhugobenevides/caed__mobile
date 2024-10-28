package com.itbenevides.caed.ui.components.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.itbenevides.caed.theme.White

@Composable
fun AlertDialogError(message: String) {
    val dialogState = remember { mutableStateOf(true) }

    if (dialogState.value) {
        AlertDialog(
            onDismissRequest = {
                dialogState.value = false
            },
            title = { Text(text = "Alert") },
            text = { Text(text = message) },
            confirmButton = {
                Button(
                    onClick = {
                        dialogState.value = false
                    }
                ) {
                    Text(
                        text = "Ok",
                        color = White
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewAlertDialogError() {
    AlertDialogError("This is an error message")
}