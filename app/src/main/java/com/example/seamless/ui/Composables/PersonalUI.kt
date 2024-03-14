package com.example.seamless.ui.Composables

import android.media.audiofx.AudioEffect.Descriptor
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
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
import android.graphics.Color
//import androidx.compose.ui.graphics.Color // This color is not for the charts, If you want to include this color whatever, use
//android.graphics.Color.BLACK for your Color.BLACK instead
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seamless.FunctionCard
import com.example.seamless.FunctionList
import com.example.seamless.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.XAxis.XAxisPosition
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import data.DataSource
import model.Function

import java.util.Arrays

//Personal UI

class MyChartActivity : AppCompatActivity() {
    private lateinit var lineChart: LineChart
    private lateinit var xValues: MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        lineChart = findViewById(R.id.chart)

        var description: Description = Description()
        description.setText("Income")
        description.setPosition(150f, 15f)
        lineChart.setDescription(description)
        lineChart.getAxisRight().setDrawLabels(false)

        val xValues = listOf("Income1", "Income2", "Income3")

        val xAxis: XAxis = lineChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setLabelCount(3)
        xAxis.setGranularity(1f)

        val yAxis: YAxis = lineChart.axisLeft
        yAxis.setAxisMinimum(0f)
        yAxis.setAxisMaximum(100f)
        yAxis.setAxisLineWidth(2f)
        yAxis.setAxisLineColor(Color.BLACK)
        yAxis.setLabelCount(10)


        xAxis.valueFormatter = IndexAxisValueFormatter(xValues) // This is for the list of x values,
        //If you want to get the list from input, use this below
        /*
        private lateinit var xValues: List<String>
        fun setupChart() {
            val xAxis: XAxis = lineChart.xAxis
            xAxis.valueFormatter = IndexAxisValueFormatter(xValues)
        }
         */

        val entries1 = ArrayList<Entry>()
        entries1.add(Entry(0f, 10f))
        entries1.add(Entry(1f, 10f))
        entries1.add(Entry(2f, 10f))

        val entries2 = ArrayList<Entry>()
        entries2.add(Entry(0f, 5f))
        entries2.add(Entry(1f, 15f))
        entries2.add(Entry(2f, 25f))

        
    }
}


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