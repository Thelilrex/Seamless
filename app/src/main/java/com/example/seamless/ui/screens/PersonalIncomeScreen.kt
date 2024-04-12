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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun PersonalIncomesScreen(
    dataToList: () -> Unit = {},
    onDeleteButtonClicked: () -> Unit = {},
    onDialogueConfirmButtonClicked: () -> Unit = {},
    onAddButtonClicked:() -> Unit = {},
    databaseObject: Any
) {
    /*TODO: Call dataToList to turn database object into list then set browseItem*/
    var browseItem = listOf(
        BrowseItem(1, "Foods", "Cat1", "Burgers", 500.0),
        BrowseItem(2, "Entertainments", "Cat2", "Games", 114.0),
        BrowseItem(3, "Transfers", "Cat3", "George", 810.0),
        BrowseItem(4, "Transport", "Cat4", "Taxi", 1919.0),
        BrowseItem(5, "Cloth", "Cat5", "Shirts", 514.0),
        BrowseItem(6, "Rent", "Cat6", "House", 2.0),
    )
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
    val pieChartColors = listOf(
        Color(0xFFE91E63),
        Color(0xFF9C27B0),
        Color(0xFF673AB7),
        Color(0xFFFF9800),
        Color(0xFF3F51B5),
        Color(0xFF2196F3),
        Color(0xFF00BCD4),
        Color(0xFF009688),
        Color(0xFF4CAF50),
        Color(0xFF8BC34A),
        Color(0xFFCDDC39),
        Color(0xFFFFEB3B),
        Color(0xFFFFC107),
        Color(0xFFFF5722),
        Color(0xFF795548),
        Color(0xFF9E9E9E),
        Color(0xFF607D8B)
    )
    val incomeTypes = listOf(incomeType1.value, incomeType2.value, incomeType3.value)

    Column(modifier = Modifier.fillMaxHeight()) {

        Column {
            Column(modifier = Modifier.weight(0.8f)) {
                Row(modifier = Modifier.padding(16.dp)) {
                    PersonalIncomesPieChart(
                        browseItems = browseItem,
                        colors = pieChartColors,
                        modifier = Modifier
                    )
                }
                Row(modifier = Modifier.padding(16.dp)) {
                    PersonalIncomeLegend(
                        browseItems = browseItem,
                        colors = pieChartColors,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                BrowseItemsLayout(browseItem)
            }
            Column(modifier = Modifier.weight(0.1f)) {
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {showDialog.value = true
//                            onAddButtonClicked()
                                  },
                        modifier = Modifier
                            .weight(1f)
                            .height(70.dp)
                    ) {
                        Text("Add")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            onDeleteButtonClicked()
                        },
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {
                            onDialogueConfirmButtonClicked()
                        }
                    ) {
                        Text("Confirm")
                    }
                    Button(
                        onClick = {
                            onAddButtonClicked()
                        }
                    ) {
                        Text("Add Screen")
                    }
                }
            }
        }
    }
}


@Composable
fun PersonalIncomesPieChart(
    browseItems: List<BrowseItem>,
    colors: List<Color>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(16.dp)
            .aspectRatio(1f)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val total = browseItems.sumOf {it.amount}
            var startAngle = 0f
            browseItems.forEachIndexed { index, item ->
                val angle = (item.amount.toFloat() / total) * 360f
                val color = colors.getOrElse(index) { Color.Black }
                drawArc(
                    color = color,
                    startAngle = startAngle,
                    sweepAngle = angle.toFloat(),
                    useCenter = true,
                    topLeft = Offset.Zero,
                    size = Size(size.width, size.height)
                )
                startAngle += angle.toFloat()
            }
        }
    }
}

@Composable
fun PersonalIncomeLegend(browseItems: List<BrowseItem>, colors: List<Color>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        browseItems.forEachIndexed { index, item ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .background(color = colors.getOrElse(index) { Color.Black }, shape = CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = item.name)
            }
        }
    }
}

@Composable
fun BrowseItemsLayout(browseItems: List<BrowseItem>) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Name",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
            )
            Text(
                text = "Categories",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
            )
            Text(
                text = "Description",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
            )
            Text(
                text = "Amount",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
            )
        }
    }
    LazyColumn{
        items(browseItems) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = item.name, modifier = Modifier.weight(1f))
                Text(text = item.categories, modifier = Modifier.weight(1f))
                Text(text = item.description, modifier = Modifier.weight(1f))
                Text(text = "$${item.amount}", modifier = Modifier.weight(1f))
            }
        }
    }
}
data class BrowseItem(val setNumber: Int, val name: String, val categories: String,
                      val description: String, val amount: Double)

@Composable
@Preview(backgroundColor = 0xFFFFFFFF)
fun PersonalIncomesScreenPreview()
{
    PersonalIncomesScreen(
        databaseObject = {}
    )
}