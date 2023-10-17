//package com.example.mobileproliseum.components
//
//import android.app.TimePickerDialog
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.Button
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import java.time.LocalTime
//
//@Composable
//fun TimerPicker() {
//    var isTimePickerVisible by remember { mutableStateOf(false) }
//    var selectedTime by remember { mutableStateOf(LocalTime.now()) }
//
//    Surface(
//        modifier = Modifier.fillMaxSize(),
//        color = MaterialTheme.colorScheme.background
//    ) {
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Button(
//                onClick = { isTimePickerVisible = true },
//                modifier = Modifier.padding(8.dp)
//            ) {
//                Text(text = "Select Time")
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            Text(text = "Selected Time: ${selectedTime.hour}:${selectedTime.minute}")
//
//            if (isTimePickerVisible) {
//                TimePickerDialog( // Substitua pelo nome da classe do seu TimePicker
//                    time = selectedTime,
//                    onTimeSelected = { newTime ->
//                        selectedTime = newTime
//                        isTimePickerVisible = false // Feche o diálogo após a seleção
//                    }
//                )
//
//                Button(
//                    onClick = {
//                        isTimePickerVisible = false
//                        // Faça algo com o valor selecionado em "selectedTime"
//                    },
//                    modifier = Modifier.padding(8.dp)
//                ) {
//                    Text(text = "OK")
//                }
//            }
//        }
//    }
//}
