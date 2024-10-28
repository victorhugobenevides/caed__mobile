package com.itbenevides.caed.ui.components.packages.detail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itbenevides.caed.theme.Gray
import com.itbenevides.caed.theme.GrayDark
import com.itbenevides.core.data.model.getMockPackages

@Composable
fun DetailItem(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 12.sp,
            color = Gray,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = value,
            fontSize = 12.sp,
            color = GrayDark,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(0.8f)
                .align(Alignment.Bottom),
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDetailItem() {
    val packages = getMockPackages()
    DetailItem(label = "Código", value = packages.packageGroup.code)
}