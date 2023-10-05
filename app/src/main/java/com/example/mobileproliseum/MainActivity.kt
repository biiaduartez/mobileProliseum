package com.example.mobileproliseum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.senai.sp.jandira.mobileproliseum.home.screen.HomeScreen
import br.senai.sp.jandira.mobileproliseum.recuperar_senha.screen.ReiniciarSenhaScreen
import com.example.mobileproliseum.perfil_jogador.screen.PerfilJogadorScreen
import com.example.mobileproliseum.ui.theme.MobileProliseumTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileProliseumTheme {
                MainContent()
            }
        }
    }

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun MainContent() {
        var selectedTab by remember { mutableStateOf(0) }

        val items = listOf(
            BottomNavItem("Home", Icons.Default.Home),
            BottomNavItem("Profile", Icons.Default.Person),
            BottomNavItem("Settings", Icons.Default.Settings)
        )

        // Configurar o NavController
        val navController = rememberAnimatedNavController()

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Conteúdo principal da atividade aqui
            // Configurar o NavHost para a navegação entre telas
            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f) // Ocupa todo o espaço restante
            ) {
                composable("home") {
                    HomeScreen()
                }
                composable("profile") {
                    PerfilJogadorScreen()
                }
                composable("settings") {
                    ReiniciarSenhaScreen()
                }
            }

            // Adicionar a barra de navegação inferior personalizada
            BottomNavigationBar(
                items = items,
                selectedTab = selectedTab,
                onTabSelected = { index -> selectedTab = index },
                navController = navController // Passar o NavController para a BottomNavigationBar
            )
        }
    }


    @Composable
    fun BottomNavigationBar(
        items: List<BottomNavItem>,
        selectedTab: Int,
        onTabSelected: (Int) -> Unit,
        navController: NavController
    ) {
        val density = LocalDensity.current.density

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp * density) // Altura do BottomNavigationBar
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            Color.Blue,
                            Color.Blue
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
                ) {
                    onTabSelected(index)
                    // Navegar para a tela correspondente ao índice clicado
                    when (index) {
                        0 -> navController.navigate("home")
                        1 -> navController.navigate("profile")
                        2 -> navController.navigate("settings")
                    }
                }
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
}
