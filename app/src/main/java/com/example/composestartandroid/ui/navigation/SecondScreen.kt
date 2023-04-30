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
internal fun SecondScreen(
    onOneClick: () -> Unit,
    onTwoClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Second  screen")
        Text(text = "To one",
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    onOneClick()
                })
        Text(text = "To two",
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    onTwoClick()
                })
    }
}