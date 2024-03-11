package com.example.seamless.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StartScreen(
    modifier: Modifier,
    onPersonalButtonClicked: (Int) -> Unit = {},
    onBusinessButtonClicked: (Int) -> Unit = {}
) {
    Column(
        modifier = modifier
    ) {
        Button(
            onClick = {},
            modifier = modifier
        ){
            Text(text = "Personal")
        }
        Button(
            onClick = {},
            modifier = modifier
        ){
            Text(text = "Business")
        }
    }
}

@Preview
@Composable
fun StartScreenPreview() {
    StartScreen(
        modifier = Modifier
    )
}
