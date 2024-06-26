package com.example.seamless.ui.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.seamless.database.AppDatabase
import com.example.seamless.database.Income
import kotlinx.coroutines.runBlocking

@Composable
fun ParentIncomeComponent() {
    val incomeItem = remember { mutableStateListOf<Income>() }

    AddCategories(
        modifier = Modifier,
        showDialog = remember { mutableStateOf(false) },
        incomeItem = incomeItem,
        context = LocalContext.current
    )

    PersonalIncomesScreen(
        incomeItem = incomeItem,
        context = LocalContext.current
    )
}
@Composable
fun AddCategories(
    modifier: Modifier,
    showDialog: MutableState<Boolean>,
    onConfirmButtonClicked: () -> Unit = {},
    onCancelButtonClicked: () -> Unit = {},
    incomeItem: MutableList<Income>,
    onDialogueConfirmButtonClicked: () -> Unit = {},
    context: Context
) {
    val showAddDialog = remember { mutableStateOf(false) }
    val name = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val amount = remember { mutableStateOf("") }
    val defaultPadding = 8.dp
    val id = remember { mutableStateOf("") }
    var setNumber by remember { mutableStateOf(1) }
    var categories by remember { mutableStateOf(1) }



    Column(modifier = Modifier.padding(defaultPadding)) {
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(20.dp)
                .height(50.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Button(modifier = Modifier.height(50.dp),
                onClick = {
                    id.value = "1"
                    showAddDialog.value = true
                }) {
                Text("Part Time")
            }
            Button(modifier = Modifier.height(50.dp),
                onClick = {
                    id.value = "2"
                    showAddDialog.value = true
                }) {
                Text("Job")
            }
            Button(modifier = Modifier.height(50.dp),
                onClick = {
                    id.value = "3"
                    showAddDialog.value = true
                }) {
                Text("Parents")
            }
            Button(modifier = Modifier.height(50.dp),
                onClick = {
                    id.value = "4"
                    showAddDialog.value = true
                }) {
                Text("Bonus")
            }
            Button(modifier = Modifier.height(50.dp),
                onClick = {
                    id.value = "5"
                    showAddDialog.value = true
                }) {
                Text("Gifts")
            }
            Button(modifier = Modifier.height(50.dp),
                onClick = { showAddDialog.value = true }) {
                Text("Add+")
            }
        }
        Row(
            modifier = Modifier
                .padding(30.dp)
                .height(50.dp),
            horizontalArrangement = Arrangement.spacedBy(80.dp)
        ) {
            Button(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                onClick = {
                    onCancelButtonClicked()
                }
            ){
                Text("Cancel")
            }
            if (showAddDialog.value) {
                Dialog(onDismissRequest = { showAddDialog.value = false }) {
                    Column(modifier = Modifier.padding(16.dp).background(Color.White)) {
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
                                    val income = Income( // let the user to input the data to income, and then put the income to a list of Income.
                                        name = nameState.value,
                                        description = descriptionState.value,
                                        amount = amountState.value.toDouble(),
                                        categoryID = id.value.toInt()
                                    )
                                    val dao = AppDatabase.getDatabase(context).appDao()
                                    runBlocking { dao.insertIncome(income) }
                                    showAddDialog.value = false
                                    setNumber++
                                    categories++
                                    onDialogueConfirmButtonClicked()

                                    incomeItem += income
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
}






//@Composable
//@Preview
//fun AddScreenPreview()
//{
//    AddCategories(
//        modifier = Modifier,
//        //databaseObject = Unit,
//        showDialog = remember { mutableStateOf(false) }
//    )
//}
