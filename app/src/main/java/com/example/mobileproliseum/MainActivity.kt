package com.example.mobileproliseum

import android.content.res.ColorStateList
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
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.senai.sp.jandira.mobileproliseum.home.screen.HomeScreen
import br.senai.sp.jandira.mobileproliseum.recuperar_senha.screen.ReiniciarSenhaScreen
import com.example.mobileproliseum.perfil_jogador.screen.PerfilJogadorScreen
import com.example.mobileproliseum.ui.theme.AzulEscuroProliseum
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
            BottomNavItem("", Icons.Default.Home),
            BottomNavItem("", Icons.Default.Person),
            BottomNavItem("", Icons.Default.Settings)
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
                onTabSelected = { index ->
                    selectedTab = index
                    // Navegar para a tela correspondente ao índice clicado
                    when (index) {
                        0 -> navController.navigate("home")
                        1 -> navController.navigate("profile")
                        2 -> navController.navigate("settings")
                    }
                }
            )
        }
    }

    @Composable
    fun BottomNavigationBar(
        items: List<BottomNavItem>,
        selectedTab: Int,
        onTabSelected: (Int) -> Unit
    ) {
        val density = LocalDensity.current.density

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color.Red)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp * density) // Altura do BottomNavigationBar
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
                    isSelected = selectedTab == index,
                    onTabSelected = { onTabSelected(index) }
                )
            }
        }
    }

    @Composable
    fun BottomNavButton(
        item: BottomNavItem,
        isSelected: Boolean,
        onTabSelected: () -> Unit
    ) {
        val backgroundColor = if (isSelected) AzulEscuroProliseum else AzulEscuroProliseum
        val iconColor = if (isSelected) Color.Red else Color.White

        Surface(
            modifier = Modifier
                .size(72.dp)
                .fillMaxSize()
                .background(backgroundColor)
                .clickable { onTabSelected() }, // Usar a mesma cor de fundo da Row
            color = Color.Transparent
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Icon(
                    item.icon,
                    contentDescription = null,
                    modifier = Modifier.size(25.dp),
                    tint = iconColor,
                )
            }
        }
    }


    data class BottomNavItem(
        val
        title: String, val icon: ImageVector
    )
}
