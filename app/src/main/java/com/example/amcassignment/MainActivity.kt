package com.example.amcassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.amcassignment.screens.*
import com.example.amcassignment.ui.theme.AMCAssignmentTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AMCAssignmentTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "home" ){
                    composable("home") { homeScreen(navController) }
                    composable("reservation"){ reservationScreen(navController)}
                    composable("datetime"){ datetimeScreen(navController) }
                    composable("maps") { mapScreen(navController)}
                    composable("confirmation"){ confirmationScreen(navController)}
                    composable("rating"){ ratingScreen()}
                    composable("profile"){ profileScreen(navController)}
                }
                //Greeting("Ben")
                //homeScreen()
                //reservationScreen()
                //datetimeComposable(context = this)
                //DEPRECATED timeComposable(context = this)
                //myMap(){}
                //mapScreen()
                //confirmationScreen()
                //ratingScreen()
                //profileScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
