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
fun PersonalIncomesScreen() {
    val incomeType1 = remember { mutableStateOf("") }
    val incomeType2 = remember { mutableStateOf("") }
    val incomeType3 = remember { mutableStateOf("") }
    val incomeValue1 = remember { mutableStateOf("") }
    val incomeValue2 = remember { mutableStateOf("") }
    val incomeValue3 = remember { mutableStateOf("") }

    val pieChartData = listOf(
        incomeValue1.value.toFloatOrNull() ?: 0f,
        incomeValue2.value.toFloatOrNull() ?: 0f,
        incomeValue3.value.toFloatOrNull() ?: 0f
    )
    val pieChartColors = listOf(Color.Gray, Color.Blue, Color.Yellow)
    val incomeTypes = listOf(incomeType1.value, incomeType2.value, incomeType3.value)

    Column {
        Column {
            Column(modifier = Modifier.weight(1f)) {
                Row(modifier = Modifier.padding(16.dp)) {
                    PersonalIncomesPieChart(
                        data = pieChartData,
                        colors = pieChartColors,
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    )
                    PersonalIncomeLegend(
                        incomeTypes = incomeTypes,
                        colors = pieChartColors,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
//                LazyColumn {
//                    item {
//                        PersonalIncomesPieChart(
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
                        value = incomeType1.value,
                        onValueChange = { incomeType1.value = it },
                        label = { Text("Income1") },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        value = incomeValue1.value,
                        onValueChange = { incomeValue1.value = it },
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
                        value = incomeType2.value,
                        onValueChange = { incomeType2.value = it },
                        label = { Text("Income2") },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        value = incomeValue2.value,
                        onValueChange = { incomeValue2.value = it },
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
                        value = incomeType3.value,
                        onValueChange = { incomeType3.value = it },
                        label = { Text("Income3") },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        value = incomeValue3.value,
                        onValueChange = { incomeValue3.value = it },
                        label = { Text("Value3") },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun PersonalIncomesPieChart(data: List<Float>, colors: List<Color>, modifier: Modifier = Modifier) {
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
fun PersonalIncomeLegend(incomeTypes: List<String>, colors: List<Color>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        incomeTypes.forEachIndexed { index, incomeType ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier
                    .size(16.dp)
                    .background(color = colors.getOrElse(index) { Color.Black }, shape = CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = incomeType)
            }
        }
    }
}

@Composable
@Preview
fun PersonalIncomesScreenPreview()
{
    PersonalIncomesScreen()
}