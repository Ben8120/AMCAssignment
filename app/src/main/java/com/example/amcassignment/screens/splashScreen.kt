package com.example.amcassignment.screens

import android.graphics.Paint
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
fun splashScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Text(text = "Welcome to Ben's Cleaning Service!")
            Image(
                painter = painterResource(id = R.drawable.cleaner_banner),
                contentDescription = "Cleaner Banner",
                modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(10.dp)
            )
        }
        Button(
            modifier = Modifier.fillMaxWidth().padding(10.dp).align(Alignment.BottomCenter),
            onClick = {
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