package com.example.seamless.ui.Composables

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
import com.example.seamless.FunctionCard
import com.example.seamless.FunctionList
import data.DataSource
import model.Function

//Personal UI

@Composable
fun PersonalFunctionList(functionList: List<Function>, modifier: Modifier = Modifier)
{
    LazyColumn (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        items(functionList){
                function: Function -> PersonalFunctionCard(function = function,
            modifier = Modifier.padding(20.dp),

            )

        }
    }
}

@Composable
fun PersonalFunctionCard(function: Function, modifier: Modifier = Modifier)
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
                    // go to incomeUI / spendingUI /Personal3UI
                    personalDecideFunction()
                }) {
                Text(
                    text = stringResource(id = function.functionResourceId),
                    modifier = Modifier
                        .height(40.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
            }
            Row(modifier = modifier.fillMaxSize()){
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
                    Text("Bank")
                }
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
                    Text("123")
                }

            }
        }
    }
}


fun personalDecideFunction(// get functionResourceId
)
{
    if(
        true
    // functionResourceId == Income function
    )
    {
        // jump to IncomeFunctionCard
    }
    if(
        true
    // functionResourceId == Spending function
    )
    {
        // jump to SpendingFunctionCard
    }
    if(
        true
    // functionResourceId == Personal3 function
    )
    {
        // jump to Personal3FunctionCard
    }
    else
    {
        // Error
    }
}
fun IncomeFunctionJumper(function: Function, modifier: Modifier = Modifier)
{
    // go to IncomeFunctionCard
}

fun SpendingFunctionCardJumper(function: Function, modifier: Modifier = Modifier)
{
    // go to SpendingFunctionCard
}

fun Personal3FunctionCardJumper(function: Function, modifier: Modifier = Modifier)
{
    // go to Personal3FunctionCard
}


@Composable
fun DrawPersonalUI()
{
    PersonalFunctionList(
        functionList = DataSource().loadFunction(1)
    )
}

@Composable
@Preview
fun PersonalFunctionCardPreview()
{
    DrawPersonalUI()
}

//Personal UI