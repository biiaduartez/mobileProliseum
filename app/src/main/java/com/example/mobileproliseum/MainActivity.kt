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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
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
import com.example.mobileproliseum.ui.theme.MobileProliseumTheme
import com.example.mobileproliseum.ui.theme.RedProliseum
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileProliseumTheme {
                ListTimesScreen()
            }
        }
    }

    @Composable
    fun ListTimesScreen() {

        val customFontFamily = FontFamily(
            Font(R.font.font_title)
        )
        val customFontFamilyText = FontFamily(
            Font(R.font.font_poppins)
        )

        val context = LocalContext.current


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
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {

                Icon(
                    modifier = Modifier.clickable {
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent)
                    },
                    painter = painterResource(id = R.drawable.arrow_back_32),
                    contentDescription = stringResource(id = R.string.button_sair),
                    tint = Color.White
                )
            }
            Column(
                modifier = Modifier.padding(top = 100.dp),
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        Column {
                            Card(
                                modifier = Modifier
                                    .height(85.dp)
                                    .width(85.dp),
                                colors = CardDefaults.cardColors(RedProliseum)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.lol),
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    alignment = Alignment.Center,
                                    colorFilter = ColorFilter.tint(AzulEscuroProliseum)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(25.dp))

                        LazyRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            item {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.simbolo),
                                            contentDescription = ""
                                        )
                                        Text(
                                            text = "BOOM",
                                            color = Color.White,
                                            fontWeight = FontWeight(600),
                                            fontSize = 16.sp,
                                            fontFamily = customFontFamilyText,
                                            textAlign = TextAlign.Center
                                        )
                                    }

                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.simbolo),
                                            contentDescription = ""
                                        )
                                        Text(
                                            text = "BOOM ACADEMY",
                                            color = Color.White,
                                            fontWeight = FontWeight(600),
                                            fontSize = 16.sp,
                                            fontFamily = customFontFamilyText,
                                            textAlign = TextAlign.Center
                                        )

                                    }

                                    Icon(
                                        modifier = Modifier
                                            .clickable {
                                                val intent =
                                                    Intent(context, MainActivity::class.java)
                                                context.startActivity(intent)
                                            }
                                            .height(50.dp),
                                        painter = painterResource(id = R.drawable.baseline_add_24),
                                        contentDescription = stringResource(id = R.string.button_sair),
                                        tint = Color.White
                                    )
                                }


                            }
                        }

                        Spacer(modifier = Modifier.height(25.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(0.5.dp)
                                .background(Color.Red)
                        )

                        Spacer(modifier = Modifier.height(35.dp))

                        Column {
                            Card(
                                modifier = Modifier
                                    .height(85.dp)
                                    .width(85.dp),
                                colors = CardDefaults.cardColors(RedProliseum)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.csgo),
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    alignment = Alignment.Center,
                                    colorFilter = ColorFilter.tint(AzulEscuroProliseum)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(35.dp))

                        LazyRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            item {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.simbolo),
                                            contentDescription = ""
                                        )
                                        Text(
                                            text = "BOOM",
                                            color = Color.White,
                                            fontWeight = FontWeight(600),
                                            fontSize = 16.sp,
                                            fontFamily = customFontFamilyText,
                                            textAlign = TextAlign.Center
                                        )
                                    }

                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.simbolo),
                                            contentDescription = ""
                                        )
                                        Text(
                                            text = "BOOM ACADEMY",
                                            color = Color.White,
                                            fontWeight = FontWeight(600),
                                            fontSize = 16.sp,
                                            fontFamily = customFontFamilyText,
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                    Icon(
                                        modifier = Modifier
                                            .clickable {
                                                val intent =
                                                    Intent(context, MainActivity::class.java)
                                                context.startActivity(intent)
                                            }
                                            .height(50.dp),
                                        painter = painterResource(id = R.drawable.baseline_add_24),
                                        contentDescription = stringResource(id = R.string.button_sair),
                                        tint = Color.White
                                    )
                                }
                            }
                        }


                        Spacer(modifier = Modifier.height(25.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(0.5.dp)
                                .background(Color.Red)
                        )

                        Spacer(modifier = Modifier.height(35.dp))

                        Column {
                            Card(
                                modifier = Modifier
                                    .height(85.dp)
                                    .width(85.dp),
                                colors = CardDefaults.cardColors(RedProliseum)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.valorant),
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    alignment = Alignment.Center,
                                    colorFilter = ColorFilter.tint(AzulEscuroProliseum)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(35.dp))
                        LazyRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            item {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.simbolo),
                                            contentDescription = ""
                                        )
                                        Text(
                                            text = "BOOM",
                                            color = Color.White,
                                            fontWeight = FontWeight(600),
                                            fontSize = 16.sp,
                                            fontFamily = customFontFamilyText,
                                            textAlign = TextAlign.Center
                                        )
                                    }

                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.simbolo),
                                            contentDescription = ""
                                        )
                                        Text(
                                            text = "BOOM ACADEMY",
                                            color = Color.White,
                                            fontWeight = FontWeight(600),
                                            fontSize = 16.sp,
                                            fontFamily = customFontFamilyText,
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                    Icon(
                                        modifier = Modifier
                                            .clickable {
                                                val intent =
                                                    Intent(context, MainActivity::class.java)
                                                context.startActivity(intent)
                                            }
                                            .height(50.dp),
                                        painter = painterResource(id = R.drawable.baseline_add_24),
                                        contentDescription = stringResource(id = R.string.button_sair),
                                        tint = Color.White
                                    )
                                }
                            }
                        }

                    }



                }
            }
        }
    }
}

