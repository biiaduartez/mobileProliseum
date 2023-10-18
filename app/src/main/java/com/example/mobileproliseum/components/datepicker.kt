package br.senai.sp.jandira.mobileproliseum.components

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import java.util.*



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateInputSample(context: Context) {

//        val state = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
//        DatePicker(
//            state = state,
//            modifier = Modifier
//                .width(450.dp)
//                .padding(16.dp)
//                .background(
//                    brush = Brush.horizontalGradient(
//                        listOf(
//                            Color.White,
//                            Color.White
//
//                        )
//                    ),
//                    shape = RoundedCornerShape(50.dp, 50.dp, 50.dp, 50.dp)
//                ),
//        )

    val year: Int
    val month: Int
    val day: Int

    val calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val date = remember { mutableStateOf("") }
    val datePickerDialog = DatePickerDialog(
        context,
        {_: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            date.value = "$dayOfMonth/$month/$year"
        }, year, month, day
    )

        Spacer(modifier = Modifier.size(20.dp))

        OutlinedTextField(
            value = "${date.value}",
            onValueChange = {datePickerDialog.show()},
            modifier = Modifier

                .width(520.dp),
            shape = RoundedCornerShape(16.dp),
            label = {
                Text(
                    text = "Data Nascimento",
                    color = Color.White
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(255, 255, 255, 255),
                focusedBorderColor = Color(255, 255, 255, 255),
                cursorColor = Color.White
            ),
            textStyle = TextStyle(color = Color.White)
        )
}