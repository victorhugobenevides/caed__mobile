package com.itbenevides.caed.ui.components.packages.itemlist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itbenevides.caed.R
import com.itbenevides.caed.theme.Cyan
import com.itbenevides.caed.theme.Gray
import com.itbenevides.caed.theme.GrayLight
import com.itbenevides.core.data.model.Package
import com.itbenevides.core.data.model.getMockPackages

@Composable
fun PackageItem(packageItem: Package, onClick: () -> Unit) {
    Column {
        Row(
            modifier = Modifier
                .clickable { onClick() }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = packageItem.code,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f),
                color = Gray
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow),
                contentDescription = "Ver Detalhes",
                tint = Gray
            )
        }
        Box(
            modifier = Modifier
                .width(130.dp)
                .height(6.dp)
                .background(Gray.copy(alpha = 0.2f), RoundedCornerShape(12.dp))
        ) {

            Row(
                modifier = Modifier
                    .height(12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(50.0F)
                        .fillMaxHeight()
                        .background(Cyan, RoundedCornerShape(corner = CornerSize(5.dp)))
                )
                Spacer(modifier = Modifier.width(4.dp))
                Box(
                    modifier = Modifier
                        .weight(50F)
                        .fillMaxHeight()
                        .background(Gray, RoundedCornerShape(corner = CornerSize(5.dp)))
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
                .height(1.dp)
                .background(GrayLight),
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPackageItem() {
    val packages = getMockPackages()
    PackageItem(packageItem = packages.packages[0]) {
    }
}