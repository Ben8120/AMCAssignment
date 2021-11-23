package com.example.amcassignment.screens_cleaner

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.amcassignment.R
import com.example.amcassignment.screens.ratingBar

@Composable
fun viewReviewScreen(navControllerCleaner: NavController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Text(text = "Service ID:000624", modifier = Modifier.padding(10.dp))
            ratingBar(rating = 5)
            Text(text = "Client Name", modifier = Modifier.padding(10.dp))
            clientReviewBox()
            imageBox()
        }
        Button(
            modifier = Modifier.align(Alignment.BottomEnd).width(screenWidth/2).padding(10.dp),
            onClick = { navControllerCleaner.navigate("cleanerHomeScreen") {
                popUpTo("cleanerHomeScreen") {
                    inclusive = true
                }
            }}) {
            Text(text = "Back")
        }
    }
}

@Composable
fun clientReviewBox() {
    Box(modifier = Modifier.padding(10.dp)) {
        TextField(
            value = "Excellent cleaning service! They cleaned my house very well! Satisfied, will definitely call them again!",
            onValueChange = {},
            readOnly = true)
    }
}

@Composable
fun imageBox() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Reviewed Images",
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )
}