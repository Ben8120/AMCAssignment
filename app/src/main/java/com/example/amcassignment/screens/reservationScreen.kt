package com.example.amcassignment.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.amcassignment.model.Services

@Composable
fun reservationScreen(navController: NavController, serviceList: List<Services> ) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    var serviceString: String = " "

    val scrollState = rememberScrollState()
    val scrollPageState = rememberScrollState()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(bottom = 75.dp)
                .verticalScroll(scrollState)
        ) {
            Text(text = "reservation screen")
            serviceList.forEach{ service ->
                serviceCard(
                    service = service.service1,
                    onChecked = {serviceString = serviceString+service.service1+","
                                Log.d("Response", serviceString)}, //delimiter
                    onUnChecked = {
                        var oldValue = service.service1+","
                        var newValue = ""
                        serviceString = serviceString.replace(oldValue, newValue)
                        Log.d("Response", serviceString)
                                  },
                    /*
                    on check add the service name to a string with a comma at the end
                    but when unchecked, search for that word and replace it with nothing
                     */
                )
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
            pagerButtons(pageNo = 0, navController = navController, null, null)
        }
        //pager
        Button(onClick = {
            navController.navigate("datetime/$serviceString")
        }, modifier = Modifier
            .width(screenWidth / 2)
            .align(Alignment.BottomEnd)
            .padding(10.dp)) {
            Text(text = "Next")
        }
    }
}

@Composable
fun serviceCard(
    service: String,
    onChecked: ()-> Unit = {},
    onUnChecked: ()-> Unit = {},
    defaultState: Boolean = false
) {
    var checkedState by remember{ mutableStateOf(defaultState)}

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 10.dp
    ) {
        Row() {
            Checkbox(
                checked = checkedState,
                onCheckedChange = {
                                  checkedState = it
                    run (if (it) onChecked else onUnChecked)
                },
                modifier = Modifier.padding(16.dp)
            )
            Text(text = service, modifier = Modifier.padding(16.dp))
        }
    }
}