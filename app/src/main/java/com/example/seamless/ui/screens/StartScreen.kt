package com.example.seamless.ui.screens

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seamless.R

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
        SettingButton(onSettingsButtonClicked)
        ButtonsLayout(onPersonalButtonClicked, onBusinessButtonClicked)
//        Card(
//            modifier = Modifier
//        )
//        {
//            Column (modifier = modifier)
//            {
//                Image(painter = painterResource(id = R.drawable.testimage), contentDescription = "Image for test")
//                Button(
//                    modifier = Modifier,
//                    onClick = onPersonalButtonClicked)
//                {
//                    Text(
//                        text = "Personal",
//                        modifier = Modifier.size(100.dp, 40.dp),
//                        style = MaterialTheme.typography.headlineSmall
//                    )
//                }
//            }
//        }
//        Card(
//            modifier = Modifier
//        )
//        {
//            Column (modifier = modifier)
//            {
//                Button(
//                    modifier = Modifier,
//                    onClick = onBusinessButtonClicked) {
//                    Text(
//                        text = "Business",
//                        modifier = Modifier.size(100.dp, 40.dp),
//                        style = MaterialTheme.typography.headlineSmall
//                    )
//                }
//            }
//        }
    }
}

@Composable
fun SettingButton(onImageClick: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.setting),
        contentDescription = "Clickable settings",
        modifier = Modifier
            .size(100.dp, 50.dp)
            .clickable(onClick = onImageClick),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun ButtonsLayout(onPersonalClick: () -> Unit, onBusinessClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        PersonalButton(
            onImageClick = onPersonalClick,
            modifier = Modifier.weight(1f)
        )
        BusinessButton(
            onImageClick = onBusinessClick,
            modifier = Modifier.weight(1f)
        )
    }
}
@Composable
fun PersonalButton(onImageClick: () -> Unit, modifier: Modifier = Modifier) {
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
                    painter = painterResource(id = R.drawable.testimage),
                    contentDescription = "Clickable settings",
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .clickable(onClick = onImageClick)
                )
                Text(
                    text = "Personal",
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
fun BusinessButton(onImageClick: () -> Unit, modifier: Modifier = Modifier) {
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
                    painter = painterResource(id = R.drawable.testimage),
                    contentDescription = "Clickable settings",
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .clickable(onClick = onImageClick)
                )
                Text(
                    text = "Business",
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
fun StartScreenPreview() {
    StartScreen(
        modifier = Modifier
    )
}
