package com.example.mobileproliseum.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobileproliseum.R
import com.example.mobileproliseum.cadastro.screen.CadastroJogadorScreen
import com.example.mobileproliseum.ui.theme.MobileProliseumTheme

@Composable

fun header() {
    var isMenuVisible by remember { mutableStateOf(false) }

    Row(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
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

            if (isMenuVisible) {
                // Conteúdo do seu menu aqui
                Button(
                    onClick = {
                        // Ação quando um item do menu é clicado
                        isMenuVisible = false
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    // Conteúdo do item do menu
                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    MobileProliseumTheme {
        header()
    }
}