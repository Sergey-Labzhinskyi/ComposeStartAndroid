package com.example.composestartandroid.ui

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composestartandroid.R

@SuppressLint("UnrememberedMutableState")
@Composable
fun Animation() {
    var visible = mutableStateOf(false)

    Text(
        text = "Bear click ",
        fontSize = 42.sp,
        modifier = Modifier.clickable {
            visible.value = !visible.value

        }
    )
    BikeScreen(state = visible)
}
@Composable
fun test2(state: State<Boolean>) {
    AnimatedVisibility(
        visible = state.value,
        enter = slideInHorizontally(
            initialOffsetX = { it },
            animationSpec =  tween(1000)
        )
                //+ expandHorizontally(expandFrom = Alignment.End)
                + fadeIn(animationSpec = tween(durationMillis = 1000, easing = LinearEasing)),
        exit = slideOutHorizontally(targetOffsetX = { it },
            animationSpec =  tween(1000)
        )
                //+ shrinkHorizontally()
                + fadeOut(animationSpec = tween(durationMillis = 1000)),
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.ab1_inversions),
            contentDescription = "",
        )
    }

}

@Composable
fun BikeScreen(state: State<Boolean>) {
    val offsetAnimation: Dp by animateDpAsState(
        if (state.value ) 5.dp else 300.dp, tween(1000)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
    )  {

        Text(text = if (state.value)"Hello" else "Ffdfdfsfsfsfsfsfs",
            Modifier.height(90.dp)
                .absoluteOffset(x = offsetAnimation)
                .animateContentSize(
                    animationSpec = tween(durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ))
        /*Image(
            painter = painterResource(R.drawable.ab1_inversions),
            contentDescription = null,
            modifier = Modifier
                .height(90.dp)
                .absoluteOffset(x = offsetAnimation)
        )*/
        Button(
            onClick = {

                /*  bikeState = when (bikeState) {
                      BikePosition.Start -> BikePosition.Finish
                      BikePosition.Finish -> BikePosition.Start
                  }*/
            }, modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.Center)
        ) {
            Text(text = "Ride")
        }
    }
}