package com.example.seamless.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.seamless.R

@Composable
fun BalanceSheet()
{
    var asstesItems = listOf(
        AssetsItem("Revenue1", 114.0),
        AssetsItem("Revenue2", 810.0)
    )
    var liabilitiesItems = listOf(
        LiabilitiesItem("Expense1", 114.0),
        LiabilitiesItem("Expense2", 810.0)
    )
    BalanceSheetLayout(asstesItems, liabilitiesItems)
}

@Composable
fun BalanceSheetLayout(asstesItems: List<AssetsItem>, liabilitiesItems: List<LiabilitiesItem>) {
    Column(modifier = Modifier.fillMaxHeight()) {
        Divider()
        Column(modifier = Modifier.weight(1f)) {
            AssetsLayout(asstesItems = asstesItems)
            Divider()
        }
        Divider()
        Column(modifier = Modifier.weight(1f)) {
            LiabilitiesLayout(liabilitiesItems = liabilitiesItems)
            Divider()
        }
    }
}
@Composable
fun AssetsLayout(asstesItems: List<AssetsItem>)
{
    Column (modifier = Modifier) {
        Text(
            text = "Assetes",
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
        )
        Row (
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Column(modifier = Modifier.weight(1f)) {
                asstesItems.forEach{
                        asstesItem -> Text(text = asstesItem.name)
                }
            }
            Column(modifier = Modifier.weight(1f)) {
                asstesItems.forEach{
                        asstesItem -> Text(text = "$" + asstesItem.amount.toString())
                }
            }
        }
    }
}


@Composable
fun LiabilitiesLayout(liabilitiesItems: List<LiabilitiesItem>)
{
    Column (modifier = Modifier)
    {
        Text(
            text = "Liabilities",
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
        )
        Row (
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Column(modifier = Modifier.weight(1f)) {
                liabilitiesItems.forEach{
                        liabilitiesItem -> Text(text = liabilitiesItem.name)
                }
            }
            Column(modifier = Modifier.weight(1f)) {
                liabilitiesItems.forEach{
                        liabilitiesItem -> Text(text = "$" + liabilitiesItem.amount.toString())
                }
            }
        }
    }
}


data class AssetsItem(val name: String, val amount: Double)
data class LiabilitiesItem(val name: String, val amount: Double)
@Preview
@Composable
fun BalanceSheetPreview()
{
    BalanceSheet()
}