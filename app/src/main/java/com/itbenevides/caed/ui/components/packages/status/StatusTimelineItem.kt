package com.itbenevides.caed.ui.components.packages.status

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itbenevides.caed.theme.Cyan
import com.itbenevides.caed.theme.Gray
import com.itbenevides.caed.theme.GrayDark
import com.itbenevides.caed.theme.GrayLight
import com.itbenevides.core.data.model.Status
import com.itbenevides.core.data.model.getMockPackages

@Composable
fun StatusTimelineItem(status: Status) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(end = 16.dp, start = 16.dp)
        ) {
            Text(text = status.data, fontSize = 12.sp, color = Gray)
            Text(text = status.hour, fontSize = 12.sp, color = Gray)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(30.dp)
                    .background(GrayLight),

                )
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(Cyan, shape = RoundedCornerShape(6.dp))
            )
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(30.dp)
                    .background(GrayLight),
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = status.description,
            fontSize = 12.sp,
            color = GrayDark
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewStatusTimelineItem() {
    val packages = getMockPackages()
    StatusTimelineItem(
        packages.status[0]
    )
}