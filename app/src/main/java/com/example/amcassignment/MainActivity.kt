package com.example.amcassignment

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.amcassignment.model.Post
import com.example.amcassignment.repository.Repository
import com.example.amcassignment.screens.*
import com.example.amcassignment.screens_cleaner.cleanerHomeScreen
import com.example.amcassignment.screens_cleaner.jobDescriptionScreen
import com.example.amcassignment.screens_cleaner.viewReviewScreen
import com.example.amcassignment.ui.theme.AMCAssignmentTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var email: String  = ""
        var name: String = ""

        //initialize retrofit
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
/* Test API
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                Log.d("Response", response.body()?.title.toString())
            } else {
                Log.d("Response", response.errorBody().toString())
            }
        })

        viewModel.getPost2(Integer.parseInt("2"))
        viewModel.myResponse2.observe(this, Observer { response ->
            if(response.isSuccessful){
                Log.d("Response", response.body()?.title.toString())
            } else {
                Log.d("Response", /*response.errorBody().toString()*/ "Err")
            }
        })

        val myPost = Post(2,2,"Post Request", "Test Push request")
        viewModel.pushPost(myPost)
        viewModel.myResponse2.observe(this, Observer { response ->
            if(response.isSuccessful){
                Log.d("Response", response.body().toString())
                Log.d("Response", response.code().toString())
                Log.d("Response", response.message().toString())
            } else {
                Log.d("Response", response.errorBody().toString())
            }
        })*/

        viewModel.getUserCredentials(Integer.parseInt("1"))
        viewModel.userCredentialsResponse.observe(this, Observer { response ->
            Log.d("Response", "Testing connection...")
            if(response.isSuccessful){
                Log.d("Response", response.body()?.email.toString())
                name = response.body()?.name.toString()
                email = response.body()?.email.toString()
            } else {
                Log.d("Response", response.errorBody().toString())
                Log.d("Response", "Error")
                Log.d("Response", response.code().toString())
            }
        })

        viewModel.getUserCredentialsList()
        viewModel.userCredentialsListResponse.observe(this, Observer { response ->
            Log.d("Response", "Testing list connection...")
            if(response.isSuccessful){
                Log.d("Response", response.body().toString())
            } else {
                Log.d("Response", response.errorBody().toString())
                Log.d("Response", "Error")
                Log.d("Response", response.code().toString())
            }
        })

        viewModel.getServicesList()
        viewModel.servicesListResponse.observe(this, Observer { response  ->
            if (response.isSuccessful){
                Log.d("Response", response.body().toString())
            } else {
                Log.d("Response", "err")
            }
        })

        setContent {
            AMCAssignmentTheme {

                val navController = rememberNavController()
                NavHost(navController, startDestination = "splashscreen" ){

                    composable("splashscreen"){ splashScreen(navController)}

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
                    composable("profile"){ profileScreen(navController, name, email)}
                    composable("signin"){ signinScreen(navController)}
                    composable("signup"){ signupScreen(navController)}

                    //Cleaner screens
                    composable("cleanerHomeScreen"){ cleanerHomeScreen(navController)}
                    composable("viewReview"){ viewReviewScreen(navController)}
                    composable("cleanerProfileScreen"){ cleanerProfileScreen(navController, name, email)}
                    composable("jobDescriptionScreen"){ jobDescriptionScreen(navController)}
                 /* TODO: deprecated, to delete after completion of UI navigation
                val navControllerCleaner = rememberNavController()
                NavHost(navController = navControllerCleaner, startDestination = "cleanerHomeScreen") {
                    composable("cleanerHomeScreen"){ cleanerHomeScreen(navControllerCleaner)}
                    composable("viewReview"){ viewReviewScreen(navControllerCleaner)}
                    composable("cleanerProfileScreen"){ cleanerProfileScreen(navControllerCleaner) }
                }*/
                //Greeting("Ben")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
