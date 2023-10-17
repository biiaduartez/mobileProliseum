package com.example.mobileproliseum

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.senai.sp.jandira.mobileproliseum.home.screen.HomeScreen
import br.senai.sp.jandira.mobileproliseum.recuperar_senha.screen.ReiniciarSenhaScreen
import com.example.mobileproliseum.perfil_jogador.screen.PerfilJogadorScreen
import com.example.mobileproliseum.ui.theme.AzulEscuroProliseum
import com.example.mobileproliseum.ui.theme.BlackTransparentProliseum
import com.example.mobileproliseum.ui.theme.MobileProliseumTheme
import com.example.mobileproliseum.ui.theme.RedProliseum
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileProliseumTheme {
                JogadoresDisponiveisScreen()
            }
        }
    }

    @Composable
    fun JogadoresDisponiveisScreen() {

        val customFontFamily = FontFamily(
            Font(R.font.font_title)
        )
        val customFontFamilyText = FontFamily(
            Font(R.font.font_poppins)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            AzulEscuroProliseum, AzulEscuroProliseum
                        )
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fundotelas),
                    contentDescription = "",
                )
            }

            Text(
                text = "JOGADORES DISPONIVEIS",
                modifier = Modifier
                    .padding(start = 20.dp, top = 65.dp)
                    .width(180.dp),
                color = Color.White,
                fontSize = 24.sp,
                fontFamily = customFontFamilyText,
                fontWeight = FontWeight(900)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 180.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .background(
                                    Brush.horizontalGradient(
                                        listOf(
                                            BlackTransparentProliseum,
                                            BlackTransparentProliseum
                                        )
                                    )
                                )
                                .width(280.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.superpersonicon),
                                    contentDescription = " ",
                                    alignment = Alignment.Center
                                )

                                Text(
                                    text = stringResource(id = R.string.label_nome_jogador),
                                    textAlign = TextAlign.Center,
                                    color = Color.White,
                                    fontFamily = customFontFamilyText,
                                    fontWeight = FontWeight(900),
                                    fontSize = 22.sp,
                                    modifier = Modifier.padding(top = 10.dp)
                                )

                                Row(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(16.dp),

                                    ) {
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "ELO",
                                            textAlign = TextAlign.Center,
                                            color = Color.White,
                                            fontFamily = customFontFamilyText,
                                            fontWeight = FontWeight(600),
                                            modifier = Modifier.padding(10.dp)
                                        )

                                        Image(
                                            painter = painterResource(id = R.drawable.elo),
                                            contentDescription = ""
                                        )

                                        Text(
                                            text = "DIAMOND V",
                                            textAlign = TextAlign.Center,
                                            color = Color.White,
                                            fontFamily = customFontFamilyText,
                                            fontWeight = FontWeight(600),
                                            modifier = Modifier.padding(top = 10.dp)
                                        )
                                    }

                                    Spacer(modifier = Modifier.width(25.dp))

                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "FUNÇÃO",
                                            textAlign = TextAlign.Center,
                                            color = Color.White,
                                            fontFamily = customFontFamilyText,
                                            fontWeight = FontWeight(600),
                                            modifier = Modifier.padding(10.dp)
                                        )

                                        Image(
                                            painter = painterResource(id = R.drawable.mid),
                                            contentDescription = "",
                                            modifier = Modifier.height(45.dp)
                                        )

                                        Text(
                                            text = "MID",
                                            textAlign = TextAlign.Center,
                                            color = Color.White,
                                            fontFamily = customFontFamilyText,
                                            fontWeight = FontWeight(600),
                                            modifier = Modifier.padding(top = 10.dp)
                                        )
                                    }
                                }

                                Text(
                                    text = "HORÁRIO",
                                    textAlign = TextAlign.Center,
                                    color = Color.White,
                                    fontFamily = customFontFamilyText,
                                    fontWeight = FontWeight(600),
                                    modifier = Modifier.padding(top = 10.dp)
                                )

                                // SUBSTITUIR OS TEXT PELO COMPONENTE DE TIME ( IMPORTAR DO GIT DO GABRIEL)

                                Text(
                                    text = "19:00 - 22:00",
                                    textAlign = TextAlign.Center,
                                    color = Color.White,
                                    fontFamily = customFontFamilyText,
                                    fontWeight = FontWeight(600),
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                        .width(50.dp)
                                )




                                Button(
                                    onClick = { /*TODO*/ },
                                    colors = ButtonDefaults.buttonColors(Color.Transparent)
                                ) {
                                    Text(text = "Mais Informações")
                                }


                            }

                        }

                        Spacer(modifier = Modifier.height(30.dp))
                        
                        Box(
                            modifier = Modifier
                                .background(
                                    Brush.horizontalGradient(
                                        listOf(
                                            BlackTransparentProliseum,
                                            BlackTransparentProliseum
                                        )
                                    )
                                )
                                .width(280.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.superpersonicon),
                                    contentDescription = " ",
                                    alignment = Alignment.Center
                                )

                                Text(
                                    text = stringResource(id = R.string.label_nome_jogador),
                                    textAlign = TextAlign.Center,
                                    color = Color.White,
                                    fontFamily = customFontFamilyText,
                                    fontWeight = FontWeight(900),
                                    fontSize = 22.sp,
                                    modifier = Modifier.padding(top = 10.dp)
                                )

                                Row(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(16.dp),

                                    ) {
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "ELO",
                                            textAlign = TextAlign.Center,
                                            color = Color.White,
                                            fontFamily = customFontFamilyText,
                                            fontWeight = FontWeight(600),
                                            modifier = Modifier.padding(10.dp)
                                        )

                                        Image(
                                            painter = painterResource(id = R.drawable.elo),
                                            contentDescription = ""
                                        )

                                        Text(
                                            text = "DIAMOND V",
                                            textAlign = TextAlign.Center,
                                            color = Color.White,
                                            fontFamily = customFontFamilyText,
                                            fontWeight = FontWeight(600),
                                            modifier = Modifier.padding(top = 10.dp)
                                        )
                                    }

                                    Spacer(modifier = Modifier.width(25.dp))

                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "FUNÇÃO",
                                            textAlign = TextAlign.Center,
                                            color = Color.White,
                                            fontFamily = customFontFamilyText,
                                            fontWeight = FontWeight(600),
                                            modifier = Modifier.padding(10.dp)
                                        )

                                        Image(
                                            painter = painterResource(id = R.drawable.mid),
                                            contentDescription = "",
                                            modifier = Modifier.height(45.dp)
                                        )

                                        Text(
                                            text = "MID",
                                            textAlign = TextAlign.Center,
                                            color = Color.White,
                                            fontFamily = customFontFamilyText,
                                            fontWeight = FontWeight(600),
                                            modifier = Modifier.padding(top = 10.dp)
                                        )
                                    }
                                }

                                Text(
                                    text = "HORÁRIO",
                                    textAlign = TextAlign.Center,
                                    color = Color.White,
                                    fontFamily = customFontFamilyText,
                                    fontWeight = FontWeight(600),
                                    modifier = Modifier.padding(top = 10.dp)
                                )

                                // SUBSTITUIR OS TEXT PELO COMPONENTE DE TIME ( IMPORTAR DO GIT DO GABRIEL)

                                Text(
                                    text = "19:00 - 22:00",
                                    textAlign = TextAlign.Center,
                                    color = Color.White,
                                    fontFamily = customFontFamilyText,
                                    fontWeight = FontWeight(600),
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                        .width(50.dp)
                                )




                                Button(
                                    onClick = { /*TODO*/ },
                                    colors = ButtonDefaults.buttonColors(Color.Transparent)
                                ) {
                                    Text(text = "Mais Informações")
                                }


                            }

                        }
                    }
                }
            }
        }
    }
}


