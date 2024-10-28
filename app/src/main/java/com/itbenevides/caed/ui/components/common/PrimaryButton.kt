package com.itbenevides.caed.ui.components.common

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.itbenevides.caed.theme.Black
import com.itbenevides.caed.theme.Yellow

@Composable
fun PrimaryButton(
    text: String,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Yellow,
            contentColor = Black
        ),
        shape = RectangleShape,
        modifier = modifier,
        enabled = enabled
    ) {
        Text(text = text, fontSize = 18.sp)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPrimaryButton() {
    PrimaryButton(text = "Test", onClick = {}, enabled = true)
}