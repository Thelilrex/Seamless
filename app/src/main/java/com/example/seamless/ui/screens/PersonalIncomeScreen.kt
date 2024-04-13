package com.example.seamless.ui.screens

import android.content.Context
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
import com.example.seamless.database.AppDatabase
import com.example.seamless.database.Income
import kotlinx.coroutines.runBlocking

@Composable
fun PersonalIncomesScreen(
    onDeleteButtonClicked: () -> Unit = {},
    onDialogueConfirmButtonClicked: () -> Unit = {},
    onAddButtonClicked:() -> Unit = {},
    incomeToList: () -> Unit = {},
    context: Context
) {
    val incomeItem = remember { mutableListOf<Income>()}

    val income: Income = Income(name = "Name1", description = "Description1", amount = 150.0, categoryID = 1)

    val showDeleteDialog = remember { mutableStateOf(false) }

    val buttonDouble1 = remember { mutableStateOf(0.0) }

    val incomeType1 = remember { mutableStateOf("") }
    val incomeType2 = remember { mutableStateOf("") }
    val incomeType3 = remember { mutableStateOf("") }
    val incomeValue1 = remember { mutableStateOf("") }
    val incomeValue2 = remember { mutableStateOf("") }
    val incomeValue3 = remember { mutableStateOf("") }

    var setNumber by remember { mutableStateOf(1) }
    var categories by remember { mutableStateOf(1) }
    val idState = remember { mutableStateOf("") }

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
                        income = incomeItem,
                        colors = pieChartColors,
                        modifier = Modifier
                    )
                }
                Row(modifier = Modifier.padding(16.dp)) {
                    PersonalIncomeLegend(
                        income = incomeItem,
                        colors = pieChartColors,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                BrowseItemsLayout(incomeItem)
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
                        onClick = {onAddButtonClicked()}, // Shows the dialog
//                            onAddButtonClicked()

                        modifier = Modifier
                            .weight(1f)
                            .height(70.dp)
                    ) {
                        Text("Add")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            showDeleteDialog.value = true
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
        if (showDeleteDialog.value) {
            Dialog(onDismissRequest = { showDeleteDialog.value = false }) {
                Column(modifier = Modifier
                    .padding(16.dp)
                    .background(Color.White)) {
                    Text(text = "Enter an ID：")
                    OutlinedTextField(
                        value = idState.value,
                        onValueChange = { idState.value = it},
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
                                val dao = AppDatabase.getDatabase(context).appDao()
                                runBlocking { dao.deleteIncomeById(idState.value.toInt())}
                                showDeleteDialog.value = false
                            }
                        ) {
                            Text("Confirm")
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun PersonalIncomesPieChart(
    income: List<Income>,
    colors: List<Color>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(16.dp)
            .aspectRatio(1f)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val total = income.sumOf {it.amount}
            var startAngle = 0f
            income.forEachIndexed { index, item ->
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
fun PersonalIncomeLegend(income: List<Income>, colors: List<Color>, modifier: Modifier = Modifier) {
//    fun PersonalIncomeLegend(browseItems: List<BrowseItem>, colors: List<Color>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        income.forEachIndexed { index, item ->
//            browseItems.forEachIndexed { index, item ->
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
fun BrowseItemsLayout(income: List<Income>) {
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
        items(income) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = item.name, modifier = Modifier.weight(1f))
                val text = when (item.categoryID) {
                    1 -> "Food"
                    2 -> "Entertainments"
                    3 -> "Rent"
                    4 -> "Transport"
                    5 -> "Cloth"
                    else -> "Else"
                }
                Text(
                    text = text,
                    modifier = Modifier.weight(1f)
                )
                Text(text = item.description.toString(), modifier = Modifier.weight(1f))
                Text(text = "$${item.amount}", modifier = Modifier.weight(1f))
            }
        }
    }

}

//@Composable
//@Preview(backgroundColor = 0xFFFFFFFF)
//fun PersonalIncomesScreenPreview()
//{
//    PersonalIncomesScreen(
//        databaseObject = {}
//    )
//}