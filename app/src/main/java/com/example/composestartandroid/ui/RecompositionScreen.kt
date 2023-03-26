package com.example.composestartandroid.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*

/**
 * 1. Передача State в параметрах. При передача State в Example1 и дальше в Example2, при условии,
 * что Example1 НЕ читает значение, а только прокидывает в Example2. То в Example1 рекомпозиция
 * НЕ ВЫПОЛНИТЬСЯ!!!, если Example1 читает значение, то рекомпозиция выполниться в двух функциях.
 * 2. Передача занчения в параметрах. При передачи занчения в Example1 и дальше в Example2
 * рекомпозиция выполниться в друх функциях, т.к чтение стейта происходит при вызове Example1.
 *
 * Передача State имеет смысл, если какя-то функция просто прокидывает это State.
 */

@Composable
fun RecompositionScreen() {
    val text = remember { mutableStateOf("hello") }

    Column {
        Example1(text)
        Button(
            onClick = { text.value = "world" }
        ) {
            Text("Click me")
        }
    }
}

@Composable
fun Example1(text: State<String>) {
    Log.d("Example", "Example1 recomposition")
    // Text(text.value)
    Example2(text)
}

@Composable
fun Example2(text: State<String>) {
    Log.d("Example", "Example2 recomposition")
    Text(text.value)
}