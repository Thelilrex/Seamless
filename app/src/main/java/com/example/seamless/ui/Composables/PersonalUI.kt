package com.example.seamless.ui.Composables

import android.content.Context
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
import android.widget.LinearLayout
import android.graphics.Color
import androidx.compose.ui.graphics.Color as ComposeColor
//This color is not for the charts, If you want to include this color whatever, use
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
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import data.DataSource
import model.Function

import java.util.Arrays

//Personal UI

fun configureLineChart(lineChart: LineChart) {
    val description = Description().apply {
        text = "Income"
        setPosition(150f, 15f)
    }
    lineChart.description = description
    lineChart.axisRight.isEnabled = false

    val xValues = listOf("Jan", "Feb", "Mar","Apr","May", "Jun", "Jul",
        "Aug", "Sep", "Oct", "Nov", "Dec")
    lineChart.xAxis.apply {
        position = XAxis.XAxisPosition.BOTTOM
        setLabelCount(3)
        granularity = 1f
        valueFormatter = IndexAxisValueFormatter(xValues)
    }

    lineChart.axisLeft.apply {
        axisMinimum = 0f
        axisMaximum = 100f
        axisLineWidth = 2f
        axisLineColor = Color.BLACK
        setLabelCount(10, true)
    }

    val entries1 = listOf(
        Entry(0f, 60f),
        Entry(1f, 57f),
        Entry(2f, 63f),
        Entry(3f, 60f),
        Entry(4f, 57f),
        Entry(5f, 63f),
        Entry(6f, 60f),
        Entry(7f, 57f),
        Entry(8f, 63f),
        Entry(9f, 60f),
        Entry(10f, 57f),
        Entry(11f, 63f),
        Entry(12f, 60f)
    )

    val entries2 = listOf(
        Entry(0f, 5.4f),
        Entry(1f, 6.2f),
        Entry(2f, 7.2f),
        Entry(3f, 6.3f),
        Entry(4f, 5.7f),
        Entry(5f, 6.3f),
        Entry(6f, 6.0f),
        Entry(7f, 5.7f),
        Entry(8f, 6.3f),
        Entry(9f, 6.0f),
        Entry(10f, 5.7f),
        Entry(11f, 6.3f),
        Entry(12f, 6.0f)
    )

    val entries3 = listOf(
        Entry(0f, 20f),
        Entry(1f, 37f),
        Entry(2f, 53f),
        Entry(3f, 10f),
        Entry(4f, 27f),
        Entry(5f, 43f),
        Entry(6f, 20f),
        Entry(7f, 47f),
        Entry(8f, 23f),
        Entry(9f, 50f),
        Entry(10f, 57f),
        Entry(11f, 33f),
        Entry(12f, 80f)
    )

    val dataSet1 = LineDataSet(entries1, "Food").apply {
        color = Color.BLUE
    }

    val dataSet2 = LineDataSet(entries2, "Transportation").apply {
        color = Color.GREEN
    }

    val dataSet3 = LineDataSet(entries3, "Entertainment").apply {
        color = Color.RED
    }

    val lineData = LineData(dataSet1, dataSet2, dataSet3)
    lineChart.data = lineData
    lineChart.invalidate()
}


class MyChartActivity : AppCompatActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.layout)

    val chartContainer = findViewById<LinearLayout>(R.id.chart)
    val lineChart = ChartUtils.createLineChart(this)
    chartContainer.addView(lineChart)
}

    class ChartUtils {
        companion object {
            fun createLineChart(context: Context): LineChart {
                val lineChart = LineChart(context)

                lineChart.axisRight.isEnabled = false
                val xAxis = lineChart.xAxis
                xAxis.position = XAxis.XAxisPosition.BOTTOM
                xAxis.setDrawGridLines(false)

                val yAxisLeft = lineChart.axisLeft
                yAxisLeft.setDrawGridLines(true)


                val entries = ArrayList<Entry>()
                entries.add(Entry(1f, 2f))
                entries.add(Entry(2f, 3f))
                entries.add(Entry(3f, 5f))
                val dataSet = LineDataSet(entries, "Sample")
                dataSet.color = Color.BLUE
                dataSet.valueTextColor = Color.BLACK
                dataSet.valueTextSize = 12f

                val lineData = LineData(dataSet)
                lineChart.data = lineData

                return lineChart
            }
        }
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
    //DrawPersonalUI()
    MyChartActivity()
}

//Personal UI