package com.example.mobileproliseum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.mobileproliseum.home.screen.HomeScreen
import com.example.mobileproliseum.ui.theme.MobileProliseumTheme
import com.example.mobileproliseum.ui.theme.RedProliseum

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileProliseumTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "menu") {
                        composable("menu") {
                            Greeting(navController = navController)
                        }
                        composable("home") {
                            HomeScreen() // Certifique-se de passar os parâmetros necessários, se houver
                        }
                    }
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(navController: NavController, modifier: Modifier = Modifier) {
    var isMenuVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Conteúdo do menu que aparecerá quando isMenuVisible for verdadeiro
        if (isMenuVisible) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(RedProliseum, RedProliseum),
                        )
                    )
            ) {
                // Conteúdo do item do menu com ação de navegação
                Text(
                    text = "Home",
                    modifier = Modifier
                        .padding(16.dp, top = 55.dp)
                        .clickable {
                            navController.navigate("home") // Navega para a rota "home"
                        },
                    color = Color.White
                )
            }
        }

        // IconButton que permanecerá visível na parte superior
        IconButton(
            onClick = { isMenuVisible = !isMenuVisible },
            modifier = Modifier
                .size(48.dp)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.logocadastro),
                contentDescription = "Menu Icon",
                tint = if (isMenuVisible) Color.White else Color.Black
            )
        }
    }
}
