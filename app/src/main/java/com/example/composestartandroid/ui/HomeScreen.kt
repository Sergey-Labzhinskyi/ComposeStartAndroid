package com.example.composestartandroid.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
internal fun HomeScreen() {
    BoxLesson4()
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}

/**
 * Lesson 3
 * ///////////////////////////////////////////////////////////////////////////////////////////////
 */
@Composable
private fun Lesson3() {
    Text(
        text = "Home Screen",
        modifier = Modifier
            .background(color = Color.Red)
            .fillMaxWidth(),
        fontSize = 32.sp,
        color = Color.Green,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Center
    )
}

/**
 * Lesson 4
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 */
@Composable
private fun ColumnLesson4() {
    Column(
        modifier = Modifier
            .background(color = Color.Blue)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = "Title", fontSize = 32.sp
        )
        Text(
            modifier = Modifier.align(Start), text = "Description", fontSize = 22.sp
        )
    }
}

@Composable
private fun RowLesson4() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Name", fontSize = 20.sp)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Surname", fontSize = 20.sp)

    }
}

@Composable
private fun BoxLesson4() {
    Box {
        Text(
            text = "N", fontSize = 48.sp,
            modifier = Modifier.background(color = Color.Green)
        )
        Text(
            text = "ame",
            modifier = Modifier
                .background(color = Color.Yellow)
                .align(BottomCenter)
        )
    }
}