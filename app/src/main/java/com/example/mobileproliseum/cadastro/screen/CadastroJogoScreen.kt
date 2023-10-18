//package br.senai.sp.jandira.mobileproliseum.cadastro.screen
//
//import android.content.Intent
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.Font
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.mobileproliseum.MainActivity
//import com.example.mobileproliseum.R
//import com.example.mobileproliseum.ui.theme.AzulEscuroProliseum
//import com.example.mobileproliseum.ui.theme.BlackTransparentProliseum
//import com.example.mobileproliseum.ui.theme.MobileProliseumTheme
//import com.example.mobileproliseum.ui.theme.RedProliseum
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CadastroJogoScreen() {
//
//    val customFontFamilyTitle = FontFamily(Font(R.font.font_title))
//    val customFontFamilyText = FontFamily(Font(R.font.font_poppins))
//    val context = LocalContext.current
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(
//                brush = Brush.horizontalGradient(
//                    listOf(
//                        AzulEscuroProliseum,
//                        AzulEscuroProliseum
//                    )
//                )
//            )
//    ) {
//        // Cabeçalho
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Top
//        ) {
//            // Botão de retorno
//            Row(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(15.dp),
//                horizontalArrangement = Arrangement.Start,
//                verticalAlignment = Alignment.Top
//            ) {
//                Icon(
//                    modifier = Modifier.clickable {
//                        val intent = Intent(context, MainActivity::class.java)
//                        context.startActivity(intent)
//                    },
//                    painter = painterResource(id = R.drawable.arrow_back_32),
//                    contentDescription = stringResource(id = R.string.button_sair),
//                    tint = Color.White
//                )
//            }
//        }
//
//        // Título e imagem de logotipo
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(top = 50.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.logocadastro),
//                contentDescription = ""
//            )
//
//            Spacer(modifier = Modifier.height(20.dp))
//            Text(
//                text = "CADASTRO",
//                fontFamily = customFontFamilyTitle,
//                fontSize = 48.sp,
//                textAlign = TextAlign.Center,
//                color = Color.White
//            )
//        }
//
//        // Conteúdo do formulário
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(top = 250.dp), // Ajuste o valor do topo para centralizar verticalmente
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Box(
//                modifier = Modifier
//                    .background(
//                        brush = Brush.horizontalGradient(
//                            listOf(
//                                BlackTransparentProliseum,
//                                BlackTransparentProliseum
//                            )
//                        ),
//                        shape = RoundedCornerShape(50.dp, 50.dp, 0.dp, 0.dp)
//                    )
//                    .padding(40.dp)
//                    .verticalScroll(rememberScrollState())
//            ) {
//                Column(
//                    modifier = Modifier.fillMaxSize(),
//                    verticalArrangement = Arrangement.Top,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    var fullNameState by remember { mutableStateOf("") }
//                    OutlinedTextField(
//                        value = fullNameState,
//                        onValueChange = { newFullName -> fullNameState = newFullName },
//                        modifier = Modifier
//                            .width(320.dp),
//                        shape = RoundedCornerShape(16.dp),
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
//                        label = {
//                            Text(
//                                text = stringResource(id = R.string.label_nickname),
//                                color = Color.White,
//                                fontFamily = customFontFamilyText,
//                                fontWeight = FontWeight(600),
//                            )
//                        },
//                        colors = TextFieldDefaults.outlinedTextFieldColors(
//                            unfocusedBorderColor = Color(255, 255, 255, 255),
//                            focusedBorderColor = Color(255, 255, 255, 255),
//                            cursorColor = Color.White,
//                            disabledPlaceholderColor = Color.White,
//                        ),
//                        textStyle = TextStyle(color = Color.White)
//                    )
//                    Spacer(modifier = Modifier.height(80.dp))
//
//                    Text(
//                        text = stringResource(id = R.string.label_game),
//                        fontSize = 30.sp,
//                        fontFamily = customFontFamilyText,
//                        fontWeight = FontWeight(900),
//                        color = Color.White
//                    )
//
//                    // Imagens de jogos
//                    val gameImages = listOf(
//                        R.drawable.csgo,
//                        R.drawable.lol,
//                        R.drawable.valorant
//                    )
//
//                    gameImages.forEach { gameId ->
//                        Image(
//                            painter = painterResource(id = gameId),
//                            contentDescription = ""
//                        )
//                        Spacer(modifier = Modifier.height(80.dp))
//                    }
//
//                    Spacer(modifier = Modifier.height(60.dp))
//
//
//                    // Rótulo de função e imagens de função
//                    Text(
//                        text = stringResource(id = R.string.label_funcao),
//                        fontFamily = customFontFamilyText,
//                        fontSize = 30.sp,
//                        fontWeight = FontWeight(900),
//                        color = Color.White
//                    )
//
//
//                    val functionImages = listOf(
//                        Pair(R.drawable.top, R.string.label_nome_top),
//                        Pair(R.drawable.jungle, R.string.label_nome_jungler),
//                        Pair(R.drawable.mid, R.string.label_nome_mid),
//                        Pair(R.drawable.adc, R.string.label_nome_adc),
//                        Pair(R.drawable.suporte, R.string.label_nome_suporte)
//                    )
//
//                    functionImages.forEach { (imageId, labelId) ->
//                        Image(
//                            painter = painterResource(id = imageId),
//                            contentDescription = ""
//                        )
//                        Text(
//                            text = stringResource(id = labelId),
//                            fontFamily = customFontFamilyText,
//                            fontWeight = FontWeight(900),
//                            color = Color.White,
//                            fontSize = 25.sp,
//                            textAlign = TextAlign.Center,
//                            modifier = Modifier.fillMaxWidth()
//                        )
//                        Spacer(modifier = Modifier.height(80.dp))
//                    }
//                    Button(
//                        onClick = { /*TODO*/ },
//                        modifier = Modifier
//                            .padding(top = 20.dp)
//                            .width(300.dp)
//                            .height(48.dp),
//                        shape = RoundedCornerShape(73.dp),
//                        colors = ButtonDefaults.buttonColors(RedProliseum)
//
//                    ) {
//                        Icon(
//                            painter = painterResource(id = R.drawable.logocadastro),
//                            contentDescription = stringResource(id = R.string.button_proximo),
//                            tint = Color(255, 255, 255, 255)
//                        )
//                        Text(
//                            text = stringResource(id = R.string.button_proximo),
//                            fontSize = 22.sp,
//                            textAlign = TextAlign.Center,
//                            color = Color.White,
//                            fontFamily = customFontFamilyText,
//                            fontWeight = FontWeight(900),
//
//                            )
//                    }
//
//                }
//            }
//        }
//    }
//
//}
//
//
//
//
//@Preview(showBackground = true)
//@Composable
//fun CadastroJogoScreenPreview() {
//    MobileProliseumTheme {
//        CadastroJogoScreen()
//    }
//}
//
