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
import androidx.navigation.NavController
import com.example.amcassignment.R

@Composable
fun profileScreen(navController: NavController) {
    Box() {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Profile Screen")
            Icon(painter = painterResource(id = R.drawable.ic_baseline_person_24), contentDescription = "Profile Logo", modifier = Modifier
                .height(75.dp)
                .width(75.dp))
            userFields(label = "First Name", data = "Mun")
            userFields(label = "Last Name", data = "Yi")
            userFields(label = "E-mail", data = "munyi624@gmail.com")
            Button(onClick = {
                navController.navigate("home") {
                    popUpTo("home") {
                        inclusive = true
                    }
                }
            }) {
                Text(text = "Back")
            }
        }
    }

}

@Composable
fun userFields(label: String, data: String) {
    var text by remember { mutableStateOf(TextFieldValue(data)) }
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)) {
        Text(text = label, Modifier.width(100.dp).padding(top = 15.dp))
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