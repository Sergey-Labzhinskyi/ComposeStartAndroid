package com.example.composestartandroid.ui

import android.annotation.SuppressLint
import com.example.composestartandroid.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
internal fun HomeScreen() {
    Lesson5()
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

/**
 * Lesson 5
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 */
@Composable
private fun Lesson5() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color.Blue, Color.Green, Color.Red, Color.Yellow),
                    ),
                    shape = RoundedCornerShape(12.dp)
                )
                .border(
                    width = 3.dp,
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.Cyan,
                            Color.Magenta,
                            Color.Black
                        )
                    ),
                    shape = RoundedCornerShape(12.dp)
                )
                .width(150.dp)
                .height(150.dp)
        ) {
        }

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://developer.android.com/images/android-go/next-billion-users_856.png")
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ab1_inversions),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape)
        )
    }
}