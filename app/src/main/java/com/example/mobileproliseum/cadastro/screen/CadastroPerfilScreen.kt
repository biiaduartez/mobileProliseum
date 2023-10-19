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
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardOptions
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
//import androidx.compose.ui.text.input.PasswordVisualTransformation
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
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CadastroPerfilScreen() {
//
//    val customFontFamily = FontFamily(
//        Font(R.font.font_title) // Substitua pelo nome da fonte personalizada
//    )
//    val customFontFamilyText = FontFamily(
//        Font(R.font.font_poppins)
//    )
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
//        Column(
//            modifier = Modifier.fillMaxSize()
//        ) {
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
//                    tint = Color(255, 255, 255, 255)
//                )
//            }
//
//        }
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(top = 20.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//
//            ) {
//            Image(
//                painter = painterResource(id = R.drawable.logocadastro),
//                contentDescription = ""
//            )
//            Text(
//                text = "CADASTRO",
//                fontFamily = customFontFamily,
//                fontSize = 48.sp,
//                textAlign = TextAlign.Center,
//                color = Color.White
//
//            )
//        }
//        Column(
//            modifier = Modifier
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(top = 190.dp)
//                    .background(
//                        brush = Brush.horizontalGradient(
//                            listOf(
//                                BlackTransparentProliseum,
//                                BlackTransparentProliseum
//                            )
//                        ),
//                        shape = RoundedCornerShape(50.dp, 50.dp, 0.dp, 0.dp)
//                    )
//
//
//            ) {
//
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(top = 30.dp),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//
//                    ) {
//                    var userNameState by remember { mutableStateOf("") }
//                    OutlinedTextField(
//                        value = userNameState,
//                        onValueChange = { newUserName -> userNameState = newUserName },
//                        modifier = Modifier
//
//                            .width(320.dp),
//                        shape = RoundedCornerShape(16.dp),
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
//                        label = {
//                            Text(
//                                text = stringResource(id = R.string.label_user),
//                                color = Color.White,
//                                fontFamily = customFontFamilyText,
//                                fontWeight = FontWeight(600),
//                            )
//                        },
//                        colors = TextFieldDefaults.outlinedTextFieldColors(
//                            unfocusedBorderColor = Color(255, 255, 255, 255),
//                            focusedBorderColor = Color(255, 255, 255, 255),
//                            cursorColor = Color.White,
//                            disabledBorderColor = Color.White,
//                        ),
//                        textStyle = TextStyle(color = Color.White)
//                    )
//                    Spacer(modifier = Modifier.height(20.dp))
//                    var fullNameState by remember { mutableStateOf("") }
//                    OutlinedTextField(
//                        value = fullNameState,
//                        onValueChange = { newFullName -> fullNameState = newFullName },
//                        modifier = Modifier
//
//                            .width(320.dp),
//                        shape = RoundedCornerShape(16.dp),
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
//                        label = {
//                            Text(
//                                text = stringResource(id = R.string.label_nome),
//                                color = Color.White,
//                                fontFamily = customFontFamilyText,
//                                fontWeight = FontWeight(600),
//                            )
//                        },
//                        colors = TextFieldDefaults.outlinedTextFieldColors(
//                            unfocusedBorderColor = Color(255, 255, 255, 255),
//                            focusedBorderColor = Color(255, 255, 255, 255),
//                            cursorColor = Color.White,
//                        ),
//                        textStyle = TextStyle(color = Color.White)
//                    )
//                    Spacer(modifier = Modifier.height(20.dp))
//                    var userEmailState by remember { mutableStateOf("") }
//                    OutlinedTextField(
//                        value = userEmailState,
//                        onValueChange = { newUserEmail -> userEmailState = newUserEmail },
//                        modifier = Modifier
//
//                            .width(320.dp),
//                        shape = RoundedCornerShape(16.dp),
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
//                        label = {
//                            Text(
//                                text = stringResource(id = R.string.label_email),
//                                color = Color.White,
//                                fontFamily = customFontFamilyText,
//                                fontWeight = FontWeight(600),
//                            )
//                        },
//                        colors = TextFieldDefaults.outlinedTextFieldColors(
//                            unfocusedBorderColor = Color(255, 255, 255, 255),
//                            focusedBorderColor = Color(255, 255, 255, 255),
//                            cursorColor = Color.White,
//
//                    )
//                    Spacer(modifier = Modifier.height(20.dp))
//                    var passwordState by remember { mutableStateOf("") }
//                    OutlinedTextField(
//                        value = passwordState,
//                        onValueChange = { newPassword -> passwordState = newPassword },
//                        modifier = Modifier
//
//                            .width(320.dp),
//                        shape = RoundedCornerShape(16.dp),
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//                        visualTransformation = PasswordVisualTransformation(),
//                        label = {
//                            Text(
//                                text = stringResource(id = R.string.label_senha),
//                                color = Color.White,
//                                fontFamily = customFontFamilyText,
//                                fontWeight = FontWeight(600),
//                            )
//                        },
//                        colors = TextFieldDefaults.outlinedTextFieldColors(
//                            unfocusedBorderColor = Color(255, 255, 255, 255),
//                            focusedBorderColor = Color(255, 255, 255, 255),
//                            cursorColor = Color.White,
//                        ),
//                        textStyle = TextStyle(color = Color.White)
//                    )
//                    Column(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(top = 50.dp),
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//
//                        Button(
//                            onClick = { /*TODO*/ },
//                            modifier = Modifier
//                                .padding(top = 20.dp)
//                                .width(300.dp)
//                                .height(48.dp),
//                            shape = RoundedCornerShape(73.dp),
//                            colors = ButtonDefaults.buttonColors(RedProliseum)
//
//                        ) {
//                            Icon(
//                                painter = painterResource(id = R.drawable.logocadastro),
//                                contentDescription = stringResource(id = R.string.button_proximo),
//                                tint = Color(255, 255, 255, 255)
//                            )
//                            Text(
//                                text = stringResource(id = R.string.button_proximo),
//                                fontSize = 22.sp,
//                                textAlign = TextAlign.Center,
//                                color = Color.White,
//                                fontFamily = customFontFamilyText,
//                                fontWeight = FontWeight(900),
//
//                                )
//                        }
//                    }
//
//                }
//
//
//            }
//
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun CadastroPerfilScreenPreview() {
//    MobileProliseumTheme {
//        CadastroPerfilScreen()
//    }
//}