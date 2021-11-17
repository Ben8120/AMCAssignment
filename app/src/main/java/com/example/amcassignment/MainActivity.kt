package com.example.amcassignment

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.amcassignment.screen.HomeScreen
import com.example.amcassignment.ui.theme.AMCAssignmentTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AMCAssignmentTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)

                //HomeScreen()
                //DefaultPreview()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Column(modifier = Modifier.fillMaxHeight()) {
        TopBar()
        testCard()
        Greeting("MY")
    }
}

@Composable
fun TopBar(){
    TopAppBar(
        title = {Text(text = "App Toolbar")},
        navigationIcon = {Icon(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = null)
                         },
    )
}

@Composable
fun testCard(){
    val paddingModifier = Modifier.padding(10.dp)
    Card(elevation = 10.dp,
        modifier = paddingModifier
            .fillMaxWidth()
            .height(200.dp)
            .clickable { }
    ) {
        Text(text = "Card with elevation sample",
        modifier = paddingModifier)
    }
}