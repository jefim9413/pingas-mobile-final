package com.example.pingbot.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun GaugeChart(percentage: Float?, victories: Int, defeats: Int) {
    val density = LocalDensity.current
    val strokeWidth = with(density) { 10.dp.toPx() }
    val gaugeDegrees = 180
    val startAngle = 180f


    val brush = Brush.horizontalGradient(
        0.1f to MaterialTheme.colorScheme.secondary,
        0.2f to MaterialTheme.colorScheme.tertiary,
        0.5f to MaterialTheme.colorScheme.primary,
    )

    BoxWithConstraints(modifier = Modifier, contentAlignment = Alignment.Center) {
        val canvasSize = minOf(constraints.maxWidth, constraints.maxHeight)
        val size = Size(canvasSize.toFloat(), canvasSize.toFloat())

        Canvas(
            modifier = Modifier
                .fillMaxSize(),
            onDraw = {

                drawArc(
                    brush = brush,
                    startAngle = startAngle,
                    sweepAngle = gaugeDegrees.toFloat(),
                    useCenter = false,
                    size = size,
                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                )


                val progressPercentage = percentage ?: 0f
                val progressSweepAngle = gaugeDegrees * (progressPercentage / 100f)
                drawArc(
                    color = Color(0xFF2fb8ac),
                    startAngle = startAngle,
                    sweepAngle = progressSweepAngle,
                    useCenter = false,
                    size = size,
                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                )
            }
        )
    }
}



