package com.example.composestartandroid.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.composestartandroid.R
import okhttp3.internal.toHexString

private const val TAG = "HomeScreen"

@Composable
internal fun HomeScreen() {
    Lesson9()
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
                //.data("https://developer.android.com/images/android-go/next-billion-users_856.png")
                .data(painterResource(id = R.drawable.ab1_inversions))
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ab1_inversions),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape)
        )
    }
}

/**
 * Lesson 6
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 */
@SuppressLint("UnrememberedMutableState")
@Composable
private fun Lesson6() {
    val counter = mutableStateOf(0)
    DisplayText(counter = counter) {
        counter.value++
    }
}

@Composable
private fun DisplayText(counter: State<Int>, onCounterClick: () -> Unit) {
    Text(
        text = "Bear click ${counter.value}",
        fontSize = 42.sp,
        modifier = Modifier.clickable(onClick = onCounterClick)
    )
}

/**
 * Lesson 8
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 * Recomposition перезапускает только те функции которые читают State, функции которые передают State
 * не перезапускаються.
 */

@SuppressLint("UnrememberedMutableState")
@Composable
private fun Lesson8() {
    val counter = mutableStateOf(0)
    MainScreen(counter = counter) {
        counter.value++
    }
}

@Composable
private fun MainScreen(
    counter: State<Int>,
    onCounterClick: () -> Unit
) {
    /**
     * Если читать counter, то MainScreen будет перезапускаться каждый раз при нажатии!!!
     */
    val counterValue = counter.value
    Log.d(TAG, "MainScreen $counterValue")
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ClickCounter(counter = counterValue) {
            onCounterClick()
        }
        InfoText(text = if (counter.value < 3) "More" else "Enough")
    }
}

@Composable
private fun ClickCounter(
    counter: Int,
    onCounterClick: () -> Unit
) {
    Log.d(TAG, "ClickCounter $counter")
    Text(
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                Log.d(TAG, "ClickCounter click")
                onCounterClick()
            },
        text = "Clicks: $counter"
    )
}

@Composable
private fun InfoText(text: String) {
    Log.d(TAG, "InfoText $text")
    Text(text = text, fontSize = 24.sp)
}

/**
 * Lesson 9
 * /////////////////////////////////////////////////////////////////////////////////////////////////
 */

@SuppressLint("UnrememberedMutableState")
@Composable
private fun Lesson9() {
    val counter = mutableStateOf(0)
    val checked = remember {mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ClickCounter2(checked.value, counter = counter) {
            counter.value++
        }
        ClickCheckBox(checked.value) {
            Log.d(TAG, "Lesson9 $it")
            checked.value = it
        }
    }
}

@Composable
private fun ClickCounter2(
    upperCase: Boolean,
    counter: State<Int>,
    onCounterClick: () -> Unit
) {
    Log.d(TAG, "ClickCounter2 $upperCase")

    /**
     * при создании remember with key, то когда ключ меняется объект пересоздасться заново.
     */

    val evenOdd = remember(upperCase) { EvenOdd(upperCase) }
    val counterValue = counter.value
    Text(
        text = "Clicks: $counterValue ${evenOdd.check(counterValue)}",
        modifier = Modifier.clickable(onClick = onCounterClick)
    )
    Log.d(TAG, "ClickCounter2 $counterValue ${evenOdd.hashCode().toHexString()}")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ClickCheckBox(
    checked: Boolean,
    onChangeChecked: (Boolean) -> Unit
) {
    Log.d(TAG, "ClickCheckBox $checked")

    Checkbox(checked = checked, onCheckedChange = {
        onChangeChecked(it)
    })
}