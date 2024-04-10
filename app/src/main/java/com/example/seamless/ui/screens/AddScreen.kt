package com.example.seamless.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddCatagories() {

    val name = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val amount = remember { mutableStateOf("") }

    Column(modifier = Modifier) {
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(16.dp).height(50.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

        }
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(16.dp).height(50.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = name.value,
                onValueChange = { name.value = it },
                label = { Text("Name") },
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(16.dp).height(50.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                        value = description.value,
                        onValueChange = { description.value = it },
                        label = { Text("Description") },
                        modifier = Modifier.weight(1f)
                    )
        }
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(16.dp).height(50.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = amount.value,
                onValueChange = { amount.value = it },
                label = { Text("Amount") },
                modifier = Modifier.weight(1f)
            )
        }
        //Buttons
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(16.dp).height(50.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

        }
    }
}

@Composable
@Preview
fun AddScreenPreview()
{
    AddCatagories()
}
