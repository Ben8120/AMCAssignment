package com.example.amcassignment.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.amcassignment.MainActivity
import com.example.amcassignment.MainViewModel
import com.example.amcassignment.MainViewModelFactory
import com.example.amcassignment.R
import com.example.amcassignment.model.UserCredentials
import com.example.amcassignment.repository.Repository

@Composable
fun signinScreen(navController: NavController, mainViewModel: MainViewModel) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Sign in screen")
            Icon(painter = painterResource(id = R.drawable.ic_baseline_person_24), contentDescription = "Profile Logo", modifier = Modifier
                .height(75.dp)
                .width(75.dp))
            userFields(label = "Email", data = "")
            userFields(label = "Password", data = "")
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                onClick = {
                    //TODO: validate credentials before signing in
                    navController.navigate("home") {
                        popUpTo("home") {
                            inclusive = true
                        }
                    }
                }) {
                Text("Sign in")
            }
            TextButton(onClick = { navController.navigate("signup") }) {
                Text(text = "Sign up instead")
            }
            TextButton(onClick = { navController.navigate("cleanerHomeScreen") }) {
                Text(text = "DEBUG CLEANERBUTTON (DELETE)")
            }
        }
        Button(onClick = {

            //val mainActivity: MainActivity = MainActivity()
            //mainActivity.postUser()
            navController.navigate("splashscreen") {
                popUpTo("splashscreen") {
                    inclusive = true
                }
            }
        },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(10.dp)
                .width(screenWidth / 2)
        ) {
            Text(text = "Back")
        }
    }
}

@Composable
fun signupScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Sign up screen")
            Icon(painter = painterResource(id = R.drawable.ic_baseline_person_24), contentDescription = "Profile Logo", modifier = Modifier
                .height(75.dp)
                .width(75.dp))
            userFields(label = "Name", data = "")
            userFields(label = "Email", data = "")
            userFields(label = "Password", data = "")
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                onClick = {
                /*TODO*/
                    navController.navigate("home") {
                        popUpTo("home") {
                            inclusive = true
                        }
                    }
                }) {
                Text("Sign up")
            }
            TextButton(onClick = {
                navController.navigate("signin") {
                    popUpTo("signin") {
                        inclusive = true
                    }
                }
            }) {
                Text(text = "Sign in instead")
            }
        }
        Button(onClick = {
            navController.navigate("splashscreen") {
                popUpTo("splashscreen") {
                    inclusive = true
                }
            }
        },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(10.dp)
                .width(screenWidth / 2)
        ) {
            Text(text = "Back")
        }
    }
}
