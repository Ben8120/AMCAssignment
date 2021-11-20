package com.example.amcassignment.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun reservationScreen(navController: NavController  ) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(bottom = 75.dp)
        ) {
            Text(text = "reservation screen")
            repeat(30){
                serviceCard()
            }
        }
        Button(onClick = {
            navController.navigate("datetime")
        }, modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter).padding(16.dp)) {
            Text(text = "Next")
        }
    }
}

@Composable
fun serviceCard() {
    val checkedState = remember{ mutableStateOf(false)}
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 10.dp
    ) {
        Row() {
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = {checkedState.value = it},
                modifier = Modifier.padding(16.dp)
            )
            Text(text = "service", modifier = Modifier.padding(16.dp))
        }
    }
}