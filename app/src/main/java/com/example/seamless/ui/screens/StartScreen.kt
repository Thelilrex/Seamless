package com.example.seamless.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import data.DataSource
import model.Function

@Composable
fun StartScreen(
    modifier: Modifier,
    onPersonalButtonClicked: () -> Unit = {},
    onBusinessButtonClicked: () -> Unit = {}
) {
    Column(
        modifier = modifier
    ) {
        Button(
            onClick = onPersonalButtonClicked,
            modifier = modifier
        ){
            Text(text = "Personal")
        }
        Button(
            onClick = onBusinessButtonClicked,
            modifier = modifier
        ){
            Text(text = "Business")
        }
    }
}

@Composable
fun SettingPart()
{
    Row{
        OutlinedButton(
            //Colors = Color.Blue,
            modifier = Modifier
                .height(60.dp)
                .padding(10.dp)
                .size(100.dp)
            ,
            onClick = {
                // enter the settings
            })
        {
            Text("Setting")
        }

    }
}
@Composable
fun FunctionList(functionList: List<Function>, modifier:Modifier = Modifier)
{
    LazyColumn (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        items(functionList){
                function: Function -> FunctionCard(function = function,
            modifier = Modifier.padding(20.dp),

            )

        }
    }
}

@Composable
fun MainPart()
{
    SettingPart()
    FunctionList(
        functionList = DataSource().loadFunction()
    )
}

@Composable
fun FunctionCard(function: Function, modifier: Modifier = Modifier)
{
    Card(
        modifier = modifier.padding(10.dp,30.dp)
    )
    {

        Column (modifier = modifier)
        {
            Image(
                painter = painterResource(id = function.imageResourceId),
                contentDescription = stringResource(id = function.functionResourceId),
                modifier = Modifier
                    .fillMaxWidth().height(130.dp),
                contentScale = ContentScale.Crop
            )
            Button(
                modifier = Modifier.fillMaxSize(),
                onClick = {
                }) {
                Text(
                    text = stringResource(id = function.functionResourceId),
                    modifier = Modifier
                        .height(40.dp),
                    style = MaterialTheme.typography.headlineSmall
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
