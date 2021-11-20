package com.example.amcassignment.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun reservationScreen(navController: NavController  ) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val scrollState = rememberScrollState()
    val scrollPageState = rememberScrollState()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(bottom = 75.dp)
                .verticalScroll(scrollState)
        ) {
            Text(text = "reservation screen")
            repeat(15){
                serviceCard()
            }
        }
        //pager
        val pageNo = 1
        Row(modifier = Modifier
            .width(screenWidth / 2)
            .align(Alignment.BottomStart)
            .padding(start = 10.dp, bottom = 10.dp)
            .horizontalScroll(scrollPageState)
        ) {
            pagerButtons(pageNo = 0, navController = navController)
        }
        //pager
        Button(onClick = {
            navController.navigate("datetime")
        }, modifier = Modifier
            .width(screenWidth / 2)
            .align(Alignment.BottomEnd)
            .padding(10.dp)) {
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
            Text(text = "[cleaning service]", modifier = Modifier.padding(16.dp))
        }
    }
}