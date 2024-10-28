package com.itbenevides.caed.ui.components.packages.itemlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itbenevides.caed.theme.GrayLight
import com.itbenevides.core.data.model.Package
import com.itbenevides.core.data.model.getMockPackages

@Composable
fun PackageList(packages: List<Package>, onItemClick: (Package) -> Unit) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp)
                .height(1.dp)
                .background(GrayLight),
        )
        for (packageItem in packages) {
            PackageItem(packageItem = packageItem, onClick = { onItemClick(packageItem) })
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPackageList() {
    val packages = getMockPackages()
    PackageList(packages = packages.packages) {
    }
}