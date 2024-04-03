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
fun BusinessScreen(
    modifier: Modifier,
    onHomeButtonClicked: () -> Unit = {},
    onIncomeButtonClicked: () -> Unit = {},
    onSpendsButtonClicked: () -> Unit = {},
    onInvestorsButtonClicked: () -> Unit = {},
) {Column(
    modifier = modifier
) {
    BusinessHomeButton(onHomeButtonClicked)
    BusinessButtonsLayout(onIncomeButtonClicked, onSpendsButtonClicked, onInvestorsButtonClicked)
}
}

@Composable
fun BusinessHomeButton(onImageClick: () -> Unit) {
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
fun BusinessButtonsLayout(onPersonalClick: () -> Unit, onBusinessClick: () -> Unit, onSpendsClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        BusinessIncomeButton(
            onImageClick = onPersonalClick,
            modifier = Modifier.weight(1f)
        )
        ExpensesButton(
            onImageClick = onBusinessClick,
            modifier = Modifier.weight(1f)
        )
        InvestorsButton(
            onImageClick = onSpendsClick,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun BusinessIncomeButton(onImageClick: () -> Unit, modifier: Modifier = Modifier) {
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
fun ExpensesButton(onImageClick: () -> Unit, modifier: Modifier = Modifier) {
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
                    text = "Expenses",
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
fun InvestorsButton(onImageClick: () -> Unit, modifier: Modifier = Modifier) {
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
                    painter = painterResource(id = R.drawable.investorsbutton),
                    contentDescription = "Clickable settings",
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .clickable(onClick = onImageClick),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = "Investors",
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
fun BusinessScreenPreview() {
    BusinessScreen(
        modifier = Modifier,
        onHomeButtonClicked = {}
    )
}
