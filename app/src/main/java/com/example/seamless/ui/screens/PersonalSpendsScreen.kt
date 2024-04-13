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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.seamless.database.Expenses
import com.example.seamless.database.Income
import kotlin.math.exp

@Composable
fun PersonalSpendsScreen(
    showDialog: MutableState<Boolean>,
    dataToList: () -> Unit = {},
    onDeleteButtonClicked: () -> Unit = {},
    onDialogueConfirmButtonClicked: () -> Unit = {},
    onAddButtonClicked:() -> Unit = {},
    //databaseObject: Any,
    expenseToList: () -> Unit = {}, // do this 2nd // do the screen(add)
) {
    /*TODO: Call dataToList to turn database object into list then set browseItem*/
//    val browseItem = remember { mutableListOf<BrowseItem>() }

    val expenseItem = remember { mutableListOf<Expenses>()}
    val showDeleteDialog = remember { mutableStateOf(false) }

    val expenses: Expenses = Expenses(name = "Name1", description = "Description1", amount = 150.0, categoryID = 1)

    var setNumber by remember { mutableStateOf(1) }
    var categories by remember { mutableStateOf(1) }

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

    Column(modifier = Modifier.fillMaxHeight()) {

        Column {
            Column(modifier = Modifier.weight(0.8f)) {
                Row(modifier = Modifier.padding(16.dp)) {
                    PersonalSpendsPieChart(
                        expenses = expenseItem,
                        colors = pieChartColors,
                        modifier = Modifier
                    )
                }
                Row(modifier = Modifier.padding(16.dp)) {
                    PersonalSpendLegend(
                        expenses = expenseItem,
                        colors = pieChartColors,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                SpendItemsLayout(expenseItem)
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
                            expenseItem.add(
                                Expenses(name = nameState.value, description = descriptionState.value,
                                amount = amountState.value.toDouble(), categoryID = categories)
                            )
                            showDialog.value = false
                            setNumber++
                            categories++
                            onDialogueConfirmButtonClicked()

                            /*TODO: Storage to database*/
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
        if (showDeleteDialog.value) {
            Dialog(onDismissRequest = { showDeleteDialog.value = false }) {
                Column(modifier = Modifier
                    .padding(16.dp)
                    .background(Color.White)) {
                    val IdState = remember { mutableStateOf("") }
                    Text(text = "Enter an ID：")
                    OutlinedTextField(
                        value = IdState.value,
                        onValueChange = { IdState.value = it},
                        label = { Text("ID") },
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
                                showDeleteDialog.value = false
                            }
                        ) {
                            Text("Cofirm")
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun PersonalSpendsPieChart(
    expenses: List<Expenses>,
    colors: List<Color>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(16.dp)
            .aspectRatio(1f)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val total = expenses.sumOf {it.amount}
            var startAngle = 0f
            expenses.forEachIndexed { index, item ->
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
fun PersonalSpendLegend(expenses: List<Expenses>, colors: List<Color>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        expenses.forEachIndexed { index, item ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .background(
                            color = colors.getOrElse(index) { Color.Black },
                            shape = CircleShape
                        )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = item.name)
            }
        }
    }
}

@Composable
fun SpendItemsLayout(expenses: List<Expenses>) {
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
        items(expenses) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = item.name, modifier = Modifier.weight(1f))
                Text(text = item.categoryID.toString(), modifier = Modifier.weight(1f))
                Text(text = item.description.toString(), modifier = Modifier.weight(1f))
                Text(text = "$${item.amount}", modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
@Preview(backgroundColor = 0xFFFFFFFF)
fun PersonalSpendsScreenPreview()
{
    PersonalSpendsScreen(
        //databaseObject = {}
        showDialog = remember { mutableStateOf(false) }
    )
}