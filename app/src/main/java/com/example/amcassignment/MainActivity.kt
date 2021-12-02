package com.example.amcassignment

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.amcassignment.model.Post
import com.example.amcassignment.model.Services
import com.example.amcassignment.model.UserCredentials
import com.example.amcassignment.repository.Repository
import com.example.amcassignment.screens.*
import com.example.amcassignment.screens_cleaner.cleanerHomeScreen
import com.example.amcassignment.screens_cleaner.jobDescriptionScreen
import com.example.amcassignment.screens_cleaner.viewReviewScreen
import com.example.amcassignment.ui.theme.AMCAssignmentTheme
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.typeOf

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    private lateinit var viewModel: MainViewModel

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var email: String = ""
        var name: String = ""

        var serviceList = emptyList<Services>()

        //location
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        var coords = fetchLocation()
        var lat: String = coords[0]
        var long: String = coords[1]

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
                //Log.d("Response", response.body().toString())
                serviceList = response.body()!!
                //Log.d("Response", serviceList.toString())
            } else {
                Log.d("Response", "err")
            }
        })

        //val newUser = UserCredentials(, "Benji", "benji@gmail.com", "12345678", false)
        /*viewModel.postUserCredentials(newUser)
        viewModel.userCredentialsPostResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                Log.d("Response", response.body().toString())
                Log.d("Response", response.code().toString())
                Log.d("Response", response.message().toString())
            } else {
                Log.d("Response", response.errorBody().toString())
            }
        })*/

        setContent {
            AMCAssignmentTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "splashscreen" ){

                    composable("splashscreen"){ splashScreen(navController)}

                    composable("home") { homeScreen(navController) }

                    composable("reservation"){ reservationScreen(navController, serviceList)}

                    composable("datetime/{services}",
                        arguments = listOf(navArgument("services") {type = NavType.StringType})
                    ){ backStackEntry -> datetimeScreen(navController, backStackEntry.arguments?.getString("services")) }

                    composable("maps/{services}/{datetime}",
                        arguments = listOf(navArgument("datetime") {type = NavType.StringType})
                    ) { backStackEntry -> mapScreen(navController, backStackEntry.arguments?.getString("services"), backStackEntry.arguments?.getString("datetime"), lat, long)}

                    composable("confirmation/{services}/{datetime}/{location}",
                        arguments = listOf(navArgument("location") {type = NavType.StringType})
                    ){ backStackEntry -> confirmationScreen(navController, backStackEntry.arguments?.getString("services"), backStackEntry.arguments?.getString("datetime"), backStackEntry.arguments?.getString("location"))}

                    composable("rating"){ ratingScreen()}
                    composable("profile"){ profileScreen(navController, name, email)}
                    composable("signin"){ signinScreen(navController, viewModel)}
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

    private fun fetchLocation(): Array<String> {
        val task  = fusedLocationProviderClient.lastLocation

        var lat: String = ""
        var long: String = ""
        var coords = arrayOf("3.0553894", "101.6960041")

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED && ActivityCompat
                .checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 101)
        }
        task.addOnSuccessListener {
            if (it != null){
                //Toast.makeText(this, "${it.latitude} ${it.longitude}", Toast.LENGTH_SHORT).show()
                lat = it.latitude.toString()
                Log.d("Response", lat.toString())
                long = it.longitude.toString()

                coords[0] = lat
                coords[1] = long
                Log.d("Response", "coords:")
                Log.d("Response", coords[0])
                Log.d("Response", coords[1])
            }
        }
        return coords
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
