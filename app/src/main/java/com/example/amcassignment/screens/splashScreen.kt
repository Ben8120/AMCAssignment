package com.example.amcassignment.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.amcassignment.R
import com.example.amcassignment.model.Services
import com.example.amcassignment.model.UserCredentials
import com.example.amcassignment.viewmodel.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun splashScreen(navController: NavController) {
    //val splashViewModel = hiltViewModel<SplashViewModel>()
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Text(text = "Welcome to Ben's Cleaning Service!")
            Image(
                painter = painterResource(id = R.drawable.cleaner_banner),
                contentDescription = "Cleaner Banner",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(10.dp)
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .align(Alignment.BottomCenter),
            onClick = {
                /*
                val services = Services(null, "test from android", "test")
                val apiInterface = ApiInterface.create().postService(services)
                apiInterface.enqueue(object : Callback<Services>{
                    override fun onResponse(call: Call<Services>, response: Response<Services>) {
                        if (response.isSuccessful){
                            Log.d("Response", response.body().toString())
                        } else {
                            response.errorBody().toString()
                        }
                        Log.d("Response", "success")
                        Log.d("Response", response.body().toString())
                        Log.d("Response", response.code().toString())
                        Log.d("Response", response.errorBody().toString())
                    }

                    override fun onFailure(call: Call<Services>, t: Throwable) {
                        Log.d("Response", "Something weird happened")
                    }
                })
                 */
                /*
                val apiInterface = ApiInterface.create().getService()
                apiInterface.enqueue(object : Callback<List<Services>>{
                    override fun onResponse(
                        call: Call<List<Services>>,
                        response: Response<List<Services>>
                    ) {
                        Log.d("Response", response.body().toString())
                    }

                    override fun onFailure(call: Call<List<Services>>, t: Throwable) {
                        Log.d("Response", "Unknown error")
                    }
                })
                 */

                navController.navigate("signin") {
                    popUpTo("signin") {
                        inclusive = true
                    }
                }
            }) {
            Text("Log In")
        }
    }
}