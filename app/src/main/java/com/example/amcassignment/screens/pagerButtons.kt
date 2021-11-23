package com.example.amcassignment.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun pagerButtons(pageNo: Int, navController: NavController, services: String?, datetime:  String?) {
    Button(onClick = { navController.navigate("home") { popUpTo("home") { inclusive = true} } }, modifier = Modifier
        .width(45.dp)
        .padding(end = 10.dp), enabled = true) {
        Text(text = "<")
    }
    Button(onClick = { navController.navigate("reservation") { popUpTo("reservation") { inclusive = true} } }, modifier = Modifier
        .width(45.dp)
        .padding(end = 10.dp), enabled = pageNo >= 1) {
        Text(text = "1")
    }
    Button(onClick = { navController.navigate("datetime/${services}") { popUpTo("maps") { inclusive = true} } }, modifier = Modifier
        .width(45.dp)
        .padding(end = 10.dp), enabled = pageNo > 2
    ) {
        Text(text = "2")
    }
    Button(onClick = { navController.navigate("maps/${services}/${datetime}") { popUpTo("maps") { inclusive = true} } }, modifier = Modifier
        .width(45.dp)
        .padding(end = 10.dp), enabled = pageNo > 3
    ) {
        Text(text = "3")
    }
}