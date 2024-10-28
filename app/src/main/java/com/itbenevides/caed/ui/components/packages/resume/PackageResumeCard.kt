package com.itbenevides.caed.ui.components.packages.resume

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itbenevides.caed.theme.Cyan
import com.itbenevides.caed.theme.Gray
import com.itbenevides.caed.theme.GrayDark
import com.itbenevides.caed.theme.GrayLight
import com.itbenevides.caed.theme.GrayMoreLight
import com.itbenevides.core.data.model.ResumePackages
import com.itbenevides.core.data.model.getMockPackages


@Composable
fun PackageResumeCard(packageData: ResumePackages) {


    val total = packageData.value1 + packageData.value2
    val receivedFraction = packageData.value1.toFloat() / total
    val missingFraction = packageData.value2.toFloat() / total

    Column(
        modifier = Modifier
            .width(250.dp)
            .background(GrayMoreLight, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(
            text = packageData.label,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = GrayDark,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
                .background(GrayMoreLight, RoundedCornerShape(12.dp))
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(receivedFraction)
                        .fillMaxHeight()
                        .background(Cyan, RoundedCornerShape(corner = CornerSize(5.dp)))
                )
                Spacer(modifier = Modifier.width(4.dp))
                Box(
                    modifier = Modifier
                        .weight(missingFraction)
                        .fillMaxHeight()
                        .background(GrayLight, RoundedCornerShape(corner = CornerSize(5.dp)))
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(Cyan, RoundedCornerShape(6.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = packageData.labelValue1,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = GrayDark,
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${(receivedFraction * 100).toInt()}%",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Gray
            )
        }
        Text(
            text = "${packageData.value1} pacotes",
            fontSize = 14.sp,
            color = Gray,
            modifier = Modifier.padding(start = 20.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(Gray, RoundedCornerShape(6.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = packageData.labelValue2,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = GrayDark,
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${(missingFraction * 100).toInt()}%",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Gray
            )
        }
        Text(
            text = "${packageData.value2} pacotes",
            fontSize = 14.sp,
            color = Gray,
            modifier = Modifier.padding(start = 20.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPackageResumeCard() {
    val packages = getMockPackages()
    PackageResumeCard(packages.resumePackages[0])
}
