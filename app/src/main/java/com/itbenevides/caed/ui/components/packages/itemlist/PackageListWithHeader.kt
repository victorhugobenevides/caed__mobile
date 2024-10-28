package com.itbenevides.caed.ui.components.packages.itemlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itbenevides.caed.theme.Black
import com.itbenevides.core.data.model.Package
import com.itbenevides.core.data.model.getMockPackages

@Composable
fun PackageListWithHeader(packages: List<Package>, onItemClick: (Package) -> Unit) {
    Column {
        Header()
        PackageList(packages = packages, onItemClick)
    }
}

@Composable
fun Header() {
    Row (Modifier.padding(bottom = 16.dp)){
        Icon(
            painter = painterResource(id = android.R.drawable.ic_menu_sort_by_size),
            contentDescription = "Filtro",
            tint = Black,
            modifier = Modifier
                .size(24.dp)
                .clip(RoundedCornerShape(4.dp))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Lista de pacotes",
            color = Black,
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPackageListWithHeader() {
    val packages = getMockPackages()

    PackageListWithHeader(packages = packages.packages) {
    }
}