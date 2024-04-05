package com.example.seamless.ui.screens

import android.widget.Space
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
fun IncomeStatementTracks()
{
    var revenueItems = listOf(
        RevenueItem("Revenue1", 114514.0),
        RevenueItem("Revenue2", 1919810.0)
    )
    var expenseItems = listOf(
        ExpenseItem("Expense1", 114514.0),
        ExpenseItem("Expense2", 1919810.0)
    )
    IncomeStatementTracksLayout(revenueItems, expenseItems)
}

@Composable
fun IncomeStatementTracksLayout(revenueItems: List<RevenueItem>, expenseItems: List<ExpenseItem>) {
    Column(modifier = Modifier.fillMaxHeight()) {
        Divider()
        RevenuesLayout(revenueItems = revenueItems)
        Divider()
        ExpensesLayout(expenseItems = expenseItems)
        Divider()
    }
}
@Composable
fun RevenuesLayout(revenueItems: List<RevenueItem>)
{
    Column (modifier = Modifier) {
        Text(
            text = "Revenues",
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
            )
        Row (
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Column(modifier = Modifier.weight(1f)) {
                revenueItems.forEach{
                    revenueItem -> Text(text = revenueItem.name)
                }
            }
            Column(modifier = Modifier.weight(1f)) {
                revenueItems.forEach{
                        revenueItem -> Text(text = "$" + revenueItem.amount.toString())
                }
            }
        }
    }
}


@Composable
fun ExpensesLayout(expenseItems: List<ExpenseItem>)
{
    Column (modifier = Modifier)
    {
        Text(
            text = "Expenses",
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
        )
        Row (
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Column(modifier = Modifier.weight(1f)) {
                expenseItems.forEach{
                        revenueItem -> Text(text = revenueItem.name)
                }
            }
            Column(modifier = Modifier.weight(1f)) {
                expenseItems.forEach{
                        revenueItem -> Text(text = "$" + revenueItem.amount.toString())
                }
            }
        }
    }
}


data class RevenueItem(val name: String, val amount: Double)
data class ExpenseItem(val name: String, val amount: Double)
@Preview
@Composable
fun IncomeStatementTracksPreview()
{
    IncomeStatementTracks()
}