package com.example.seamless.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PersonalScreen(
    onHomeButtonClicked: () -> Unit,
    modifier: Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Button(
            onClick = {},
            modifier = modifier
        ){
            Text(text = "Do Something")
        }
        Button(
            onClick = onHomeButtonClicked,
            modifier = modifier
        ){
            Text(text = "Home")
        }
    }
}

@Preview
@Composable
fun PersonalScreenPreview() {
    PersonalScreen(
        modifier = Modifier,
        onHomeButtonClicked = {})
}
