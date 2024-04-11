package com.example.seamless.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddCategories() {

    val name = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val amount = remember { mutableStateOf("") }
    val defaultPadding = 8.dp
    val id = remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(defaultPadding)) {
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(16.dp)
                .height(50.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {

            Button(modifier = Modifier.height(50.dp),
                onClick = {id.value = "1"}) {
                Text("Button1")
            }
            Button(modifier = Modifier.height(50.dp),
                onClick = {id.value = "2"}) {
                Text("Button2")
            }
            Button(modifier = Modifier.height(50.dp),
                onClick = {id.value = "3"}) {
                Text("Button3")
            }
            Button(modifier = Modifier.height(50.dp),
                onClick = {id.value = "4"}) {
                Text("Button4")
            }
            Button(modifier = Modifier.height(50.dp),
                onClick = {id.value = "5"}) {
                Text("Button5")
            }
            Button(modifier = Modifier.height(50.dp),
                onClick = { /* onclick */ }) {
                Text("Add+")
            }
        }
        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(70.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = name.value,
                onValueChange = { name.value = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(70.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = description.value,
                onValueChange = { description.value = it },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(70.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                value = amount.value,
                onValueChange = { amount.value = it },
                label = { Text("Amount") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(50.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                onClick = {
                    // Navigator to Browse Screen

                }
            ) {
                Text("Cancel")
            }
            Button(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                onClick = {

                }
            ) {
                Text("Confirm")
            }
        }
    }
}

@Composable
@Preview
fun AddScreenPreview()
{
    AddCategories()
}
