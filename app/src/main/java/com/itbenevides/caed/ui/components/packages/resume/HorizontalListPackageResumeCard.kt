package com.itbenevides.caed.ui.components.packages.resume

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itbenevides.core.data.model.ResumePackages
import com.itbenevides.core.data.model.getMockPackages

@Composable
fun HorizontalListPackageResumeCard(packages: List<ResumePackages>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .testTag("PackageList"),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(packages) { packageData ->
            PackageResumeCard(packageData)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHorizontalListPackageResumeCard() {
    val packages = getMockPackages()
    HorizontalListPackageResumeCard(packages.resumePackages)
}