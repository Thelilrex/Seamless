package com.example.seamless

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seamless.ui.theme.SeamlessTheme
import data.DataSource
import model.Function

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SeamlessTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainPart()
                }
            }
        }
    }
}
//UI
@Composable
fun LogInPart() {
    Row{
        Button(onClick = {
            // enter the settings
        })
        {
            Text("Log in")
        }
        Button(onClick = {
            // enter the settings
        })
        {
            Text("Sign up")
        }
    }
}
@Composable
fun SettingPart()
{
    Row{
        Button(onClick = {
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
    LazyColumn {
        items(functionList){
            function: Function -> FunctionCard(function = function,
            modifier = Modifier.padding(40.dp))

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
    Card(modifier = modifier)
    {
        Column {
            Image(
                painter = painterResource(id = function.imageResourceId),
                contentDescription = stringResource(id = function.functionResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = function.functionResourceId),
                modifier = Modifier
                .height(40.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
@Preview
fun FunctionCardPreview()
{
    MainPart()
}

//UI
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SeamlessTheme {
        Greeting("Android")
    }
}
// test for branch