package com.itbenevides.caed.ui.components.packages.status

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itbenevides.caed.theme.GrayDark
import com.itbenevides.caed.theme.GrayMoreLight
import com.itbenevides.caed.theme.White
import com.itbenevides.core.data.model.Status
import com.itbenevides.core.data.model.getMockPackages

@Composable
fun StatusTimeline(statusList: List<Status>) {
    Column (modifier = Modifier.background(White)){
        Text(
            text = "Status da caixa",
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            color = GrayDark
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayMoreLight, RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {

            for (statusItem in statusList) {
                StatusTimelineItem(statusItem)
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewStatusTimeline() {
    val packages = getMockPackages()
    StatusTimeline(statusList = packages.status)
}