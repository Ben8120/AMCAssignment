package com.example.amcassignment.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.amcassignment.MainActivity
import com.example.amcassignment.MainViewModel
import com.example.amcassignment.MainViewModelFactory
import com.example.amcassignment.R
import com.example.amcassignment.repository.Repository

@Composable
fun profileScreen(navController: NavController,  name: String, email: String) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.End) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Profile Screen")
                Icon(painter = painterResource(id = R.drawable.ic_baseline_person_24), contentDescription = "Profile Logo", modifier = Modifier
                    .height(75.dp)
                    .width(75.dp))
                userFields(label = "Name", data = name)
                userFields(label = "E-mail", data = email)
            }
            Button(
                modifier = Modifier.padding(10.dp),
                onClick = {
                    navController.navigate("splashscreen") {
                        popUpTo("splashscreen") {
                            inclusive = true
                        }
                    }
                },
            ) {
                Text("Sign out")
            }
        }

        Button(onClick = {
            navController.navigate("home") {
                popUpTo("home") {
                    inclusive = true
                }
            }
        },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Back")
        }
    }

}

@Composable
fun userFields(label: String, data: String) {
    var text by remember { mutableStateOf(TextFieldValue(data)) }
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)) {
        Text(text = label,
            Modifier
                .width(100.dp)
                .padding(top = 15.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            value = text,
            onValueChange = { newText ->
                text = newText
            })
    }
}