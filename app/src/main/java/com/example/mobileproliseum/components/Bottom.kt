package com.example.mobileproliseum.components


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text  // Correção: Importe a classe Text do pacote correto
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobileproliseum.R
import com.example.mobileproliseum.ui.theme.MobileProliseumTheme
import com.example.mobileproliseum.ui.theme.RedProliseum

@Composable
fun CustomButtonWithText(text: String, size: String = "1rem", onClick: () -> Unit) {
    val context = LocalContext.current
    val customFontFamilyText = FontFamily(
        Font(R.font.font_poppins)
    )
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(73.dp),
        colors = ButtonDefaults.buttonColors(RedProliseum)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontFamily = customFontFamilyText,
            fontWeight = FontWeight(900),
            color = Color.White
        )
    }
}

@Preview
@Composable
fun CustomButtonPreview() {
    MobileProliseumTheme {
        CustomButtonWithText(
            text = "FUNCIONA",
            size = "2rem"
        ) {
            // Trate o clique do botão aqui
        }
    }
}






