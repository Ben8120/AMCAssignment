package com.example.amcassignment.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun confirmationScreen(
    navController: NavController,
    services: String?,
    datetime: String?,
    location: String?
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val scrollPageState = rememberScrollState()
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(12.dp)
                .clip(RoundedCornerShape(12.dp))
                .align(Alignment.Center),
            elevation = 12.dp
        ) {
            Column(modifier = Modifier,
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "${services}", Modifier.background(Color.LightGray))
                Text(text = "${datetime}")
                Text(text = "${location}")

            }
        }

        Row(modifier = Modifier
            .width(screenWidth / 2)
            .align(Alignment.BottomStart)
            .padding(start = 10.dp, bottom = 10.dp)
            .horizontalScroll(scrollPageState)
        ) {
            pagerButtons(pageNo = 4, navController = navController, services, datetime)
        }
        val context = LocalContext.current
        Button(onClick = {
            navController.navigate("home")  { popUpTo("home") { inclusive = true} }
            Toast.makeText(
                context,
                "Your booking has been confirmed",
                Toast.LENGTH_SHORT
            ).show()
        },
            modifier = Modifier
                .width(screenWidth / 2)
                .align(Alignment.BottomEnd)
                .padding(10.dp)
        ) {
            Text(text = "Confirm")
        }
    }
}

@Composable
fun innerCard(innerText: String) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.Blue),
        elevation = 10.dp,
    ) {
        Text(text = innerText)
    }
}