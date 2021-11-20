package com.example.amcassignment.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.amcassignment.R

@Composable
fun homeScreen(navController: NavController) {
    val configuration = LocalConfiguration.current

    //val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    Box() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.cleaner_banner),
                contentDescription = "Cleaner Banner",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.weight(1.0f))
            Text(text = "profile card or booking card?")
            Spacer(modifier = Modifier.weight(1.0f))
            Row() {
                Button(onClick = {
                    navController.navigate("profile")
                },
                    modifier = Modifier
                        .width(screenWidth / 2)
                        .padding(10.dp)
                ) {
                    Text(text = "Profile")
                }
                Button(onClick = {
                    navController.navigate("reservation")
                },
                    modifier = Modifier.width(screenWidth/2).padding(10.dp)
                ) {
                    Text(text = "Book")
                }
            }
        }
    }
}