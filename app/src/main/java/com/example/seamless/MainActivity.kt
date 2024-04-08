package com.example.seamless

import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
// <<<<<<< Databases
// import com.example.seamless.ui.database.AppDao
// import com.example.seamless.ui.database.AppDatabase
// import com.example.seamless.ui.database.Category
// import com.example.seamless.ui.database.Expenses
// import com.example.seamless.ui.database.Type
// =======
// import com.example.seamless.ui.screens.PersonalIncomeScreen
// import com.example.seamless.ui.screens.PersonalScreen
// import com.example.seamless.ui.screens.PersonalSpendsScreen
// import com.example.seamless.ui.screens.StartScreen
// >>>>>>> main
import com.example.seamless.ui.theme.SeamlessTheme
import data.DataSource
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

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
                     val dao = AppDatabase.getDatabase(applicationContext).appDao()
                     LaunchedEffect(dao){
                         //dao.deleteTypeById(1)
                    }
                }
            }
        }
    }
// <<<<<<< Databases
// =======
// }
// //UI

// @Composable
// fun SettingPart()
// {
//     Row{
//         OutlinedButton(
//             //Colors = Color.Blue,
//             modifier = Modifier
//                 .height(60.dp)
//                 .padding(10.dp)
//                 .size(100.dp)
//                 ,
//             onClick = {
//             // enter the settings
//         })
//         {
//             Text("Setting")
//         }

//     }
// }
// @Composable
// fun FunctionList(functionList: List<Function>, modifier:Modifier = Modifier)
// {
//     LazyColumn (
//         modifier = modifier,
//         verticalArrangement = Arrangement.Center,
//         horizontalAlignment = Alignment.CenterHorizontally
//     )
//     {
//         items(functionList){
//             function: Function -> FunctionCard(function = function,
//             modifier = Modifier.padding(20.dp),

//             )

//         }
//     }
// }

// @Composable
// fun MainPart()
// {
//     SettingPart()
//     FunctionList(
//         functionList = DataSource().loadFunction()
//     )
// }

// @Composable
// fun FunctionCard(function: Function, modifier: Modifier = Modifier)
// {
//     //Space()
//     Card(
//         modifier = modifier.padding(10.dp,30.dp)
//     )
//     {

//         Column (modifier = modifier)
//         {
//             Image(
//                 painter = painterResource(id = function.imageResourceId),
//                 contentDescription = stringResource(id = function.functionResourceId),
//                 modifier = Modifier
//                     .fillMaxWidth().height(130.dp),
//                 contentScale = ContentScale.Crop
//             )
//             Button(
//                 modifier = Modifier.fillMaxSize(),
//                 onClick = {
//                     // go to personal/business functions
//                 }) {
//                 Text(
//                     text = stringResource(id = function.functionResourceId),
//                     modifier = Modifier
//                         .height(40.dp),
//                     style = MaterialTheme.typography.headlineSmall
//                 )
//             }
//         }
//     }
// }

// @Composable
// @Preview
// fun FunctionCardPreview()
// {
//     SeamlessApp()
// >>>>>>> main
}