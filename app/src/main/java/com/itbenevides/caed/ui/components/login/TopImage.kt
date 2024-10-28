package com.itbenevides.caed.ui.components.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itbenevides.caed.R

@Composable
fun TopImage() {
    Image(
        painter = painterResource(id = R.drawable.background_image_login),
        contentDescription = "Top Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(bottom = 16.dp)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewTopImage() {
    TopImage()
}