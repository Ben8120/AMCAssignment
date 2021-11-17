package com.example.amcassignment.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.amcassignment.Screen

@Composable
fun DetailedShowScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            /*navController.popBackStack()*/
            modifier = Modifier.clickable { navController.navigate(route = Screen.Home.route){
                popUpTo(Screen.Home.route){
                    inclusive = true
                }
            }
                                          },
            text = "Test"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailedShowScreenPreview() {
    DetailedShowScreen(navController = rememberNavController())
}