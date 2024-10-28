package com.itbenevides.caed.ui.components.packages.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itbenevides.caed.theme.Gray
import com.itbenevides.caed.theme.GrayDark
import com.itbenevides.caed.theme.White

@Composable
fun TabMenu(tabTitles: List<TabScreen>, onTabClick: (TabScreen) -> Unit) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column() {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            indicator = { tabPositions ->
                SecondaryIndicator(
                    Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .height(2.dp)
                        .padding(horizontal = 42.dp),
                        color = GrayDark
                )
            },
            containerColor = White,
            contentColor = GrayDark,
            divider = {
                Spacer(modifier = Modifier.height(8.dp))
            }

        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = {
                        onTabClick.invoke(tabTitles[index])
                        selectedTabIndex = index
                    },
                    text = {
                        Text(
                            text = title.screen,
                            fontSize = 14.sp,
                            fontWeight = if (selectedTabIndex == index) FontWeight.Bold else FontWeight.Normal,
                            color = if (selectedTabIndex == index) GrayDark else Gray,
                        )
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewTabMenu() {
    TabMenu(
        tabTitles = listOf(TabScreen.PACKAGE, TabScreen.STATUS, TabScreen.DATA)
    ) {

    }
}