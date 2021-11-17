package com.example.amcassignment.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.amcassignment.Screen
import com.example.amcassignment.data.Shows
import com.example.amcassignment.repository.ShowsRepository

@Composable
fun HomeScreen(navController: NavController) {
    Column() {
        //HomeBanner()
        val paddingModifier = Modifier.padding(10.dp)
        Text(
            modifier = Modifier.clickable { navController.navigate(route = Screen.Detail.route) },
            text = "Click Test!"
        )
        Card(elevation = 10.dp,
            modifier = paddingModifier
                .fillMaxWidth()
                .height(200.dp)
                .clickable {

                }
        ) {
            Box(modifier = Modifier.fillMaxSize()){
                Text(text = "Home page card should be at bottom",
                    modifier = paddingModifier
                        .align(Alignment.BottomStart))
            }
        }
        ProductList()
    }

}

@Composable
fun HomeBanner() {
    val paddingModifier = Modifier.padding(10.dp)
    Card(elevation = 10.dp,
        modifier = paddingModifier
            .fillMaxWidth()
            .height(200.dp)
            .clickable {

            }
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            Text(text = "Home page card should be at bottom",
                modifier = paddingModifier
                    .align(Alignment.BottomStart))
        }
    }
}

@Composable
fun ProductList(){
    val showsRepository = ShowsRepository()
    val getAllData = showsRepository.getAllData()
    LazyColumn(
        contentPadding = PaddingValues(all = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(items  = getAllData){
            show: Shows ->  CustomItem(shows = show)
        }
    }
}

/*
* Data class is the model, repository is where the data resides
* We get all the data from the repository and load it in the customitem
 */

//CustomItem is the card for the list to be loaded
@Composable
fun CustomItem(shows: Shows) {
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "${shows.id}",
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = shows.name,
            color = Color.Black,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = shows.description,
            color = Color.Black,
            fontWeight = FontWeight.Normal
        )
    }
}