package com.example.mobileproliseum.perfil_jogador.scrren

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.mobileproliseum.recuperar_senha.screen.ReiniciarSenhaScreen
import com.example.mobileproliseum.MainActivity
import com.example.mobileproliseum.R
import com.example.mobileproliseum.ui.theme.AzulEscuroProliseum
import com.example.mobileproliseum.ui.theme.MobileProliseumTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilJogadorScreen() {
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
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(painter = painterResource(id = R.drawable.background), contentDescription = "" )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PerfilJogadorScreenPreview() {
    MobileProliseumTheme {
        PerfilJogadorScreen()
    }
}