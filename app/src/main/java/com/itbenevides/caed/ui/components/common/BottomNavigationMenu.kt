package com.itbenevides.caed.ui.components.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itbenevides.caed.theme.Black
import com.itbenevides.caed.theme.Cyan
import com.itbenevides.caed.theme.GrayDark
import com.itbenevides.caed.theme.Transparent
import com.itbenevides.caed.theme.White

@Composable
fun BottomNavigationMenu() {
    var selectedIndex by remember { mutableIntStateOf(0) }

    NavigationBar(
        containerColor = White,
        tonalElevation = 4.dp,
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Início"
                )
            },
            label = { Text("Início") },
            selected = selectedIndex == 0,
            onClick = { selectedIndex = 0 },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Black,
                selectedTextColor = Black,
                indicatorColor = Cyan,
                unselectedIconColor = GrayDark,
                unselectedTextColor = GrayDark
            )
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Opções"
                )
            },
            label = { Text("Opções") },
            selected = selectedIndex == 1,
            onClick = { selectedIndex = 1 },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Black,
                selectedTextColor = Black,
                indicatorColor = Transparent,
                unselectedIconColor = GrayDark,
                unselectedTextColor = GrayDark
            )
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Tutoriais"
                )
            },
            label = { Text("Tutoriais") },
            selected = selectedIndex == 2,
            onClick = { selectedIndex = 2 },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Black,
                selectedTextColor = Black,
                indicatorColor = Transparent,
                unselectedIconColor = GrayDark,
                unselectedTextColor = GrayDark
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewBottomNavigationMenu() {
    BottomNavigationMenu()
}
