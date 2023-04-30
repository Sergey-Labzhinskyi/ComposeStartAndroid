package com.example.composestartandroid.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun FirstScreen(
    onSecondClick: () -> Unit,
    onThirdClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "First screen")
        Text(text = "To second",
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    onSecondClick()
                })
        Text(text = "To third",
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    onThirdClick()
                })
    }
}