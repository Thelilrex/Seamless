package com.example.seamless.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog

@Composable
fun PersonalIncomesScreen() {
    val showDialog = remember { mutableStateOf(false) }
    val buttonDouble1 = remember { mutableStateOf(0.0) }

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
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                        .padding(16.dp).height(50.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Button(modifier = Modifier.height(50.dp),
                        onClick = {  }) {
                        Text("Button1")
                    }
                    Button(modifier = Modifier.height(50.dp),
                        onClick = { /* onclick */ }) {
                        Text("Button2")
                    }
                    Button(modifier = Modifier.height(50.dp),
                        onClick = { /* onclick */ }) {
                        Text("Button3")
                    }
                    Button(modifier = Modifier.height(50.dp),
                        onClick = { /* onclick */ }) {
                        Text("Button4")
                    }
                    Button(modifier = Modifier.height(50.dp),
                        onClick = { /* onclick */ }) {
                        Text("Button5")
                    }
                    Button(modifier = Modifier.height(50.dp),
                        onClick = { /* onclick */ }) {
                        Text("Add+")
                    }
                }
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//                    OutlinedTextField(
//                        value = incomeType1.value,
//                        onValueChange = { incomeType1.value = it },
//                        label = { Text("Income1") },
//                        modifier = Modifier.weight(1f)
//                    )
//                    Spacer(modifier = Modifier.width(8.dp))
//                    OutlinedTextField(
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//                        value = incomeValue1.value,
//                        onValueChange = { incomeValue1.value = it },
//                        label = { Text("Value1") },
//                        modifier = Modifier.weight(1f)
//                    )
//                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {showDialog.value = true},
                        modifier = Modifier
                            .weight(1f)
                            .height(70.dp)
                    ) {
                        Text("Add")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = { /* "Delete" */ },
                        modifier = Modifier
                            .weight(1f)
                            .height(70.dp)
                    ) {
                        Text("Delete")
                    }
                }
            }
        }
    }
    if (showDialog.value) {
        Dialog(onDismissRequest = { showDialog.value = false }) {
            Column(modifier = Modifier.padding(16.dp)) {
                val nameState = remember { mutableStateOf("") }
                val amountState = remember { mutableStateOf("") }
                val descriptionState = remember { mutableStateOf("") }

                Text(text = "Input Value：")
                OutlinedTextField(
                    value = nameState.value,
                    onValueChange = { nameState.value = it },
                    label = { Text("Name") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = amountState.value,
                    onValueChange = { amountState.value = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    label = { Text("Amount") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = descriptionState.value,
                    onValueChange = { descriptionState.value = it },
                    label = { Text("Description") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        val amount = amountState.value.toDoubleOrNull() ?: 0.0
                        showDialog.value = false
                    }
                ) {
                    Text("Confirm")
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