package com.example.amcassignment.screens_cleaner

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.amcassignment.MainViewModel
import com.example.amcassignment.MainViewModelFactory
import com.example.amcassignment.R
import com.example.amcassignment.repository.Repository

/*TODO: available job list screen, previous job list screen*/
@Composable
fun cleanerHomeScreen(navControllerCleaner: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Image(
                painter = painterResource(id = R.drawable.cleaner_banner),
                contentDescription = "Cleaner Banner",
                modifier = Modifier.fillMaxWidth()
            )
            Text(text = "Upcoming Jobs", modifier = Modifier.padding(10.dp))
            workCard()
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
                onClick = { navControllerCleaner.navigate("cleanerProfileScreen") }) {
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

@Composable
fun workCard() {
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(12.dp))
            .padding(10.dp)
    ) {
        Column() {
            Text(text = "ID")
            Text(text = "datetime")
            Text(text = "services list")
        }
    }
}