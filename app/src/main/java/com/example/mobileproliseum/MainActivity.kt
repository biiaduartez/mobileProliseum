package com.example.mobileproliseum

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobileproliseum.ui.theme.AzulEscuroProliseum
import com.example.mobileproliseum.ui.theme.BlackTransparentProliseum
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
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val customFontFamily = FontFamily(Font(R.font.font_title))
    val customFontFamilyText = FontFamily(Font(R.font.font_poppins))
    val context = LocalContext.current

    var textFieldsCount by remember { mutableStateOf(1) }

    val textFieldsData = remember { mutableStateListOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        AzulEscuroProliseum,
                        AzulEscuroProliseum
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top
            ) {
                Icon(
                    modifier = Modifier.clickable {
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent)
                    },
                    painter = painterResource(id = R.drawable.arrow_back_32),
                    contentDescription = stringResource(id = R.string.button_sair),
                    tint = Color(255, 255, 255, 255)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.logocadastro),
                contentDescription = ""
            )
            Text(
                text = "CADASTRO",
                fontFamily = customFontFamily,
                fontSize = 48.sp,
                textAlign = TextAlign.Center,
                color = Color.White

            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 190.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            listOf(
                                BlackTransparentProliseum,
                                BlackTransparentProliseum
                            )
                        ),
                        shape = RoundedCornerShape(50.dp, 50.dp, 0.dp, 0.dp)
                    )

                    .verticalScroll(rememberScrollState())
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),

                        ) {
                        Text(
                            text = stringResource(id = R.string.label_rede_social),
                            fontFamily = customFontFamilyText,
                            fontSize = 25.sp,
                            fontWeight = FontWeight(900),
                            color = Color.White
                        )

                        // Exibir os OutlinedTextFields existentes
                        for (i in 0 until textFieldsCount) {
                            OutlinedTextField(
                                value = textFieldsData[i],
                                onValueChange = { newValue -> textFieldsData[i] = newValue },
                                label = {
                                    Text(
                                        "Rede Social", color = Color.White,
                                        fontFamily = customFontFamilyText,
                                        fontWeight = FontWeight(600),
                                    )
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp)
                                    .width(320.dp),
                                shape = RoundedCornerShape(16.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    unfocusedBorderColor = Color(255, 255, 255, 255),
                                    focusedBorderColor = Color(255, 255, 255, 255),
                                    cursorColor = Color.White,
                                    placeholderColor = Color.White,
                                ),
                                textStyle = TextStyle(color = Color.White)
                            )
                        }

                        // Botão para adicionar nova linha de OutlinedTextField
                        Button(
                            onClick = {
                                textFieldsCount++
                                textFieldsData.add("")
                            },
                            colors = ButtonDefaults.buttonColors(AzulEscuroProliseum),
                            modifier = Modifier
                                .padding(16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.baseline_add_24),
                                contentDescription = " "
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = stringResource(id = R.string.label_bio),
                            fontFamily = customFontFamilyText,
                            fontSize = 25.sp,
                            fontWeight = FontWeight(900),
                            color = Color.White
                        )

                        var fullBioState by remember { mutableStateOf("") }
                        OutlinedTextField(
                            value = fullBioState,
                            onValueChange = { newFullBio -> fullBioState = newFullBio },
                            modifier = Modifier
                                .height(220.dp)
                                .width(320.dp),
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            label = {
                                Text(
                                    text = stringResource(id = R.string.label_bio),
                                    color = Color.White,
                                    fontFamily = customFontFamilyText,
                                    fontWeight = FontWeight(600),
                                )
                            },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color(255, 255, 255, 255),
                                focusedBorderColor = Color(255, 255, 255, 255),
                                cursorColor = Color.White,
                                placeholderColor = Color.White,
                            ),
                            textStyle = TextStyle(color = Color.White)
                        )
                    }

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .width(300.dp)
                            .height(48.dp),
                        shape = RoundedCornerShape(73.dp),
                        colors = ButtonDefaults.buttonColors(RedProliseum)

                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.logocadastro),
                            contentDescription = stringResource(id = R.string.button_proximo),
                            tint = Color(255, 255, 255, 255)
                        )
                        Text(
                            text = stringResource(id = R.string.button_cadrastar),
                            fontSize = 22.sp,
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontFamily = customFontFamilyText,
                            fontWeight = FontWeight(900),

                            )
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobileProliseumTheme {
        Greeting("Android")
    }
}