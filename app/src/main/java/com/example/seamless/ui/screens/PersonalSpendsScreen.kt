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
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PersonalSpendsScreen() {
    val spendType1 = remember { mutableStateOf("") }
    val spendType2 = remember { mutableStateOf("") }
    val spendType3 = remember { mutableStateOf("") }
    val spendValue1 = remember { mutableStateOf("") }
    val spendValue2 = remember { mutableStateOf("") }
    val spendValue3 = remember { mutableStateOf("") }

    val pieChartData = listOf(
        spendValue1.value.toFloatOrNull() ?: 0f,
        spendValue2.value.toFloatOrNull() ?: 0f,
        spendValue3.value.toFloatOrNull() ?: 0f
    )
    val pieChartColors = listOf(Color.Gray, Color.Blue, Color.Yellow)
    val spendTypes = listOf(spendType1.value, spendType2.value, spendType3.value)

    Column {
        Column {
            Column(modifier = Modifier.weight(1f)) {
                Row(modifier = Modifier.padding(16.dp)) {
                    PersonalSpendsPieChart(
                        data = pieChartData,
                        colors = pieChartColors,
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    )
                    PersonalSpendLegend(
                        spendTypes = spendTypes,
                        colors = pieChartColors,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
//                LazyColumn {
//                    item {
//                        PersonalSpendsPieChart(
//                            data = pieChartData,
//                            colors = pieChartColors,
//                            modifier = Modifier.fillMaxSize()
//                        )
//                    }
//                }
            }
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedTextField(
                        value = spendType1.value,
                        onValueChange = { spendType1.value = it },
                        label = { Text("Spend1") },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        value = spendValue1.value,
                        onValueChange = { spendValue1.value = it },
                        label = { Text("Value1") },
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedTextField(
                        value = spendType2.value,
                        onValueChange = { spendType2.value = it },
                        label = { Text("Spend2") },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        value = spendValue2.value,
                        onValueChange = { spendValue2.value = it },
                        label = { Text("Value2") },
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedTextField(
                        value = spendType3.value,
                        onValueChange = { spendType3.value = it },
                        label = { Text("Spend3") },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        value = spendValue3.value,
                        onValueChange = { spendValue3.value = it },
                        label = { Text("Value3") },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun PersonalSpendsPieChart(data: List<Float>, colors: List<Color>, modifier: Modifier = Modifier) {
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
fun PersonalSpendLegend(spendTypes: List<String>, colors: List<Color>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        spendTypes.forEachIndexed { index, spendType ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier
                    .size(16.dp)
                    .background(color = colors.getOrElse(index) { Color.Black }, shape = CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = spendType)
            }
        }
    }
}

@Composable
@Preview
fun PersonalSpendsScreenPreview()
{
    PersonalSpendsScreen()
}