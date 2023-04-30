package com.example.composestartandroid.ui.customview

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun HomeCustomViewScreen() {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        val commonModifier = Modifier
            .size(100.dp)
            .padding(8.dp)
        DrawSimpleCircle(commonModifier)
        DrawSimpleRect(commonModifier)
        DrawSimpleRoundedRect(commonModifier, TileMode.Decal)
        DrawSimpleRoundedRect(commonModifier, TileMode.Clamp)
        DrawSimpleRoundedRect(commonModifier, TileMode.Mirror)
        DrawSimpleRoundedRect(commonModifier, TileMode.Repeated)
        DrawSimpleLine(commonModifier)
        DrawSimpleOval(commonModifier)
        DrawSimpleArc(commonModifier)
    }
}

@Composable
private fun DrawSimpleCircle(
    modifier: Modifier
) {
    Canvas(
        modifier = modifier, onDraw = {
            drawCircle(
                brush = Brush.radialGradient(listOf(Color.Red, Color.Blue, Color.Green)),
            )
        })
}

@Composable
private fun DrawSimpleRect(
    modifier: Modifier,
) {
    Canvas(modifier = modifier, onDraw = {
        drawRect(
            brush = Brush.sweepGradient(
                listOf(Color.Red, Color.Blue, Color.Green),

                )
        )
    })
}

@Composable
private fun DrawSimpleRoundedRect(
    modifier: Modifier,
    tileMode: TileMode
) {
    val start = Offset(0f, 100f)
    val end = Offset(100f, 0f)
    Canvas(modifier = modifier, onDraw = {
        drawRoundRect(
            brush = Brush.linearGradient(
                listOf(Color.Red, Color.Blue, Color.Green),
                start = start,
                end = end,
                tileMode = tileMode
            ),
        )
    })
}

@Composable
private fun DrawSimpleLine(
    modifier: Modifier
) {
    Canvas(modifier = modifier
        .background(color = Color.Gray), onDraw = {
        drawLine(
            brush = Brush.verticalGradient(
                listOf(Color.Red, Color.Blue, Color.Green),
            ),
            start = Offset(0f, 0f),
            end = Offset(size.height, size.width),
            strokeWidth = 5f
        )
    })
}

@Composable
private fun DrawSimpleOval(
    modifier: Modifier
) {
    Canvas(modifier = modifier.background(color = Color.Gray), onDraw = {

        drawOval(
            brush = Brush.linearGradient(listOf(Color.Red, Color.Blue, Color.Green)),
            size = Size(width = size.width / 2, height = size.height),
            topLeft = Offset(x = 50f, y = 0f)
        )
    })
}

@Composable
private fun DrawSimpleArc(
    modifier: Modifier
) {
    Canvas(modifier = modifier, onDraw = {
        drawArc(
            color = Color.Red,
            startAngle = 0f,  // 0f is at 3 o'clock of the circle
            sweepAngle = 180f,  // go 180° from startAngle
            useCenter = false,  // whether to fill the arc or not
            style = Stroke(width = 5.dp.toPx())
        )
    })
}

