package com.example.mobileproliseum.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.mobileproliseum.ui.theme.AzulEscuroProliseum
import com.example.mobileproliseum.ui.theme.RedProliseum


@Composable
fun MainContent() {
    var selectedTab by remember { mutableStateOf(0) }

    val items = listOf(
        BottomNavItem("Home", Icons.Default.Home),
        BottomNavItem("Profile", Icons.Default.Person),
        BottomNavItem("Settings", Icons.Default.Settings)
    )

    val density = LocalDensity.current.density
    val bottomNavHeight = (56.dp * density)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            // Conteúdo principal da atividade aqui

            // Adicionar a barra de navegação inferior personalizada
            BottomNavigationBar(
                items = items,
                selectedTab = selectedTab,
                onTabSelected = { index -> selectedTab = index }
            )
        }
    }
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    selectedTab: Int,
    onTabSelected: (Int) -> Unit
) {
    val density = LocalDensity.current.density
    val bottomNavHeight = (20.dp * density)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(3.dp)
            .background(
                Brush.horizontalGradient(
                    listOf(
                        RedProliseum,
                        RedProliseum
                    )
                )
            )
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(bottomNavHeight)
            .background(
                Brush.horizontalGradient(
                    listOf(
                        AzulEscuroProliseum,
                        AzulEscuroProliseum
                    )
                )
            )
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEachIndexed { index, item ->
            BottomNavButton(
                item = item,
                isSelected = selectedTab == index
            ) { onTabSelected(index) }
        }
    }
}


@Composable
fun BottomNavButton(
    item: BottomNavItem,
    isSelected: Boolean,
    onTabSelected: () -> Unit
) {
    val iconColor = if (isSelected) Color.Blue else Color.Black

    Card(
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .clickable { onTabSelected() },
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            color = Color.Transparent
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    item.icon,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint = iconColor
                )
                if (isSelected) {
                    Text(
                        text = item.title,
                        color = iconColor
                    )
                }
            }
        }
    }
}

data class BottomNavItem(val title: String, val icon: ImageVector)
