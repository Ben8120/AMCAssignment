package com.example.amcassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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

                    composable("datetime/{services}",
                        arguments = listOf(navArgument("services") {type = NavType.StringType})
                    ){ backStackEntry -> datetimeScreen(navController, backStackEntry.arguments?.getString("services")) }

                    composable("maps/{services}/{datetime}",
                        arguments = listOf(navArgument("datetime") {type = NavType.StringType})
                    ) { backStackEntry -> mapScreen(navController, backStackEntry.arguments?.getString("services"), backStackEntry.arguments?.getString("datetime"))}

                    composable("confirmation/{services}/{datetime}/{location}",
                        arguments = listOf(navArgument("location") {type = NavType.StringType})
                    ){ backStackEntry -> confirmationScreen(navController, backStackEntry.arguments?.getString("services"), backStackEntry.arguments?.getString("datetime"), backStackEntry.arguments?.getString("location"))}

                    composable("rating"){ ratingScreen()}
                    composable("profile"){ profileScreen(navController)}
                    composable("signin"){ signinScreen(navController)}
                    composable("signup"){ signupScreen(navController)}
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
                //signinScreen(navController)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
