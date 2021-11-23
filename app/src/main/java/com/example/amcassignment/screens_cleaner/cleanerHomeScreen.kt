package com.example.amcassignment.screens_cleaner

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

@Composable
fun cleanerHomeScreen(navControllerCleaner: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.cleaner_banner),
                contentDescription = "Cleaner Banner",
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                modifier = Modifier.padding(10.dp),
                onClick = {  }) {
                Text(
                    text = "See available jobs",
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Button(
                modifier = Modifier.padding(10.dp),
                onClick = { navControllerCleaner.navigate("viewReview") }) {
                Text(
                    text = "See previous jobs",
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Button(
                modifier = Modifier.padding(10.dp),
                onClick = {  }) {
                Text(
                    text = "Profile",
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun cleanerButton(label: String, navi: () -> Unit) {
    Button(
        modifier = Modifier.padding(10.dp),
        onClick = { navi }) {
        Text(
            text = label,
            modifier = Modifier.fillMaxWidth()
        )
    }
}