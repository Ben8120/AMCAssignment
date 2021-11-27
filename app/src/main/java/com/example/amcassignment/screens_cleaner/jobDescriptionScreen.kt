package com.example.amcassignment.screens_cleaner

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun jobDescriptionScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center) {
            Text(text = "Job Description")
            Card(
                elevation = 10.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(200.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Services: (chips of services)")
                    Text(text = "Date: 24th June")
                    Text(text = "Time: 12:00pm")
                }
            }
            Button(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Accept Job")
            }
        }
        Button(
            modifier = Modifier.width(screenWidth/2).padding(10.dp).align(Alignment.BottomEnd),
            onClick = {
            /*TODO*/
                navController.navigate("cleanerHomeScreen") {
                    popUpTo("cleanerHomeScreen") {
                        inclusive = true
                    }
                }
            }
        ) {
            Text(text = "Back")
        }
    }
}