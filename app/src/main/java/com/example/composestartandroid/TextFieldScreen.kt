package com.example.composestartandroid

import android.util.Log
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
internal fun TextFieldScreen() {
    Log.d("TestField", "TextFieldScreen()")
    val text = remember { mutableStateOf("") }
    TextFieldComponent(
        value = text,
        label = "label",
        onChangeValue = {
            Log.d("TestField", it)
            text.value = it
        })
}

@Composable
private fun TextFieldComponent(
    value: State<String>,
    label: String,
    onChangeValue: (String) -> Unit,
) {
    Log.d("TestField", "TextFieldComponent()")

    OutlinedTextField(
        value = value.value,
        placeholder = {
            Text(text = label)
        },
        onValueChange = { onChangeValue(it) })
}