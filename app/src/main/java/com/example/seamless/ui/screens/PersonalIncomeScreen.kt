package com.example.seamless.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PersonalIncomeScreen() {

    val pieChartData = listOf(2f, 3f, 5f)
    val pieChartColors = listOf(Color.Green, Color.Blue, Color.Magenta)

    LazyColumn {
        item{
            PersonalIncomePieChart(data = pieChartData, colors = pieChartColors, modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
fun PersonalIncomePieChart(data: List<Float>, colors: List<Color>, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(16.dp)
            .aspectRatio(1f)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val total = data.sum()
            var startAngle = 0f
            data.forEachIndexed { index, value ->
                val angle = (value / total) * 360f
                val color = colors.getOrElse(index) { Color.Black }
                drawArc(
                    color = color,
                    startAngle = startAngle,
                    sweepAngle = angle,
                    useCenter = true,
                    topLeft = Offset.Zero,
                    size = Size(size.width, size.height)
                )
                startAngle += angle
            }
        }
    }
}

@Composable
@Preview
fun PersonalIncomeScreenPreview()
{
    PersonalIncomeScreen()
}