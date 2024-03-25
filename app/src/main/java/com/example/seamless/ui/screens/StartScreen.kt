package com.example.seamless.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StartScreen(
    modifier: Modifier,
    onPersonalButtonClicked: () -> Unit = {},
    onBusinessButtonClicked: () -> Unit = {},
    onSettingsButtonClicked: () -> Unit = {}
) {
    Column(
        modifier = modifier
    ) {
        Card(
            modifier = Modifier
        )
        {
            Column (modifier = modifier)
            {
                Button(
                    modifier = Modifier,
                    onClick = onSettingsButtonClicked) {
                    Text(
                        text = "Settings",
                        modifier = Modifier.size(100.dp, 40.dp),
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
        }
        Card(
            modifier = Modifier
        )
        {
            Column (modifier = modifier)
            {
                Button(
                    modifier = Modifier,
                    onClick = onPersonalButtonClicked) {
                    Text(
                        text = "Personal",
                        modifier = Modifier.size(100.dp, 40.dp),
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
        }
        Card(
            modifier = Modifier
        )
        {
            Column (modifier = modifier)
            {
                Button(
                    modifier = Modifier,
                    onClick = onBusinessButtonClicked) {
                    Text(
                        text = "Business",
                        modifier = Modifier.size(100.dp, 40.dp),
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
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
