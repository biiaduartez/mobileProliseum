package com.example.mobileproliseum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.mobileproliseum.cadastro.screen.CadastroPerfilScreen
import br.senai.sp.jandira.mobileproliseum.home.screen.HomeScreen
import br.senai.sp.jandira.mobileproliseum.recuperar_senha.screen.ReiniciarSenhaScreen
import com.example.mobileproliseum.cadastro.screen.CadastroJogadorScreen
import com.example.mobileproliseum.perfil_jogador.screen.PerfilJogadorScreen
import com.example.mobileproliseum.perfil_organizador.screen.PerfilOrganizacaoScreen
import com.example.mobileproliseum.perfil_time.screen.PerfilTimeScreen
import com.example.mobileproliseum.ui.theme.AzulEscuroProliseum
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
                        composable("perfilJogador") {
                            PerfilJogadorScreen() // Certifique-se de passar os parâmetros necessários, se houver
                        }

                        composable(route = "time") {
                            PerfilTimeScreen()
                        }

                        composable(route = "perfil") {
                            PerfilJogadorScreen()
                        }

                        composable(route = "perfil") {
                            PerfilOrganizacaoScreen()
                        }

                    }
                }
            }
        }
    }

    @Composable
    fun Greeting(navController: NavController, modifier: Modifier = Modifier) {
        var isMenuVisible by remember { mutableStateOf(false) }
        val customFontFamilyText = FontFamily(Font(R.font.font_poppins))

        Box(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .height(intrinsicSize = IntrinsicSize.Min)
                    .background(AzulEscuroProliseum),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                IconButton(
                    onClick = { isMenuVisible = !isMenuVisible },
                    modifier = Modifier.size(48.dp)
                        .background(Color.Transparent)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.logocadastro),
                        contentDescription = "Menu Icon",
                        tint = if (isMenuVisible) Color.Red else Color.White
                    )
                }

                if (isMenuVisible) {
                    Column(
                        modifier = Modifier.fillMaxSize().padding(top = 80.dp)
                    ) {
                        MenuItem(navController, "home", R.drawable.baseline_home_24, "Home")
                        Spacer(modifier = Modifier.height(15.dp))
                        MenuItem(navController, "perfil", R.drawable.baseline_person_24, "Perfil")
                        Spacer(modifier = Modifier.height(15.dp))
                        MenuItem(
                            navController,
                            "time",
                            R.drawable.baseline_people_alt_24,
                            "Meu Time"
                        )
                        Spacer(modifier = Modifier.height(558.dp))
                        MenuItem(navController, "Home", R.drawable.baseline_arrow_back_24, "Sair")
                    }
                }

                IconButton(
                    onClick = { navController.navigate("perfilJogador") },
                    modifier = Modifier.size(48.dp).background(Color.Transparent)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.superpersonicon),
                        contentDescription = "Menu Icon",
                        tint = Color.White
                    )
                }
            }
        }
    }

    @Composable
    fun MenuItem(navController: NavController, route: String, iconId: Int, label: String) {
        Row {
            Image(painter = painterResource(id = iconId), contentDescription = "")
            Text(
                text = label,
                modifier = Modifier.clickable { navController.navigate(route) },
                fontSize = 15.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.font_poppins)),
                fontWeight = FontWeight(900)
            )
        }
    }
}