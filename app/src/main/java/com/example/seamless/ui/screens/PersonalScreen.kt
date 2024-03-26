package com.example.seamless.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seamless.R

@Composable
fun PersonalScreen(
    modifier: Modifier,
    onHomeButtonClicked: () -> Unit = {},
    onIncomeButtonClicked: () -> Unit = {},
    onSpendsButtonClicked: () -> Unit = {},
) {
    Column(
        modifier = modifier
    ) {
        HomeButton(onHomeButtonClicked)
        PersonalButtonsLayout(onIncomeButtonClicked, onSpendsButtonClicked)
    }
}

@Composable
fun HomeButton(onImageClick: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.returnbutton),
        contentDescription = "Clickable settings",
        modifier = Modifier
            .size(100.dp, 50.dp)
            .clickable(onClick = onImageClick),
        contentScale = ContentScale.FillBounds
    )
}
@Composable
fun PersonalButtonsLayout(onPersonalClick: () -> Unit, onBusinessClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        IncomeButton(
            onImageClick = onPersonalClick,
            modifier = Modifier.weight(1f)
        )
        SpendsButton(
            onImageClick = onBusinessClick,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun IncomeButton(onImageClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.incomebutton),
                    contentDescription = "Clickable settings",
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .clickable(onClick = onImageClick),
                        contentScale = ContentScale.FillBounds
                )
                Text(
                    text = "Income",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .padding(vertical = 16.dp),
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun SpendsButton(onImageClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.spendsbutton),
                    contentDescription = "Clickable settings",
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .clickable(onClick = onImageClick),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = "Spends",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .padding(vertical = 16.dp),
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun PersonalScreenPreview() {
    PersonalScreen(
        modifier = Modifier,
        onHomeButtonClicked = {}
        )
}
