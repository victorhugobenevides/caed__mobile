package com.itbenevides.caed.ui.components.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itbenevides.caed.R

@Composable
fun LogoImage() {
    Image(
        painter = painterResource(id = R.drawable.logo_caed),
        contentDescription = "Logo Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(40.dp)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLogoImage() {
    LogoImage()
}