package com.itbenevides.caed.ui.components.packages.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itbenevides.caed.theme.Black
import com.itbenevides.caed.theme.GrayLight
import com.itbenevides.caed.theme.White
import com.itbenevides.core.data.model.Package
import com.itbenevides.core.data.model.getMockPackages

@Composable
fun PackageDetails(packageItem: Package) {
    Column(
        modifier = Modifier
            .background(White, RoundedCornerShape(8.dp)),
    ) {
        Text(
            text = "Dados da caixa",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp),
            color = Black
        )

        val details = listOf(
            "CÓDIGO" to packageItem.code,
            "PONTO DE ENTREGA" to packageItem.deliveryPoint,
            "MUNICÍPIO" to "${packageItem.city}/${packageItem.state}"
        )

        for ((label, value) in details) {
            DetailItem(label = label, value = value)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
                    .height(1.dp)
                    .background(GrayLight),
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPackageDetails() {

    val packages = getMockPackages()

    PackageDetails(packageItem = packages.packageGroup)
}