package com.example.amcassignment.screens

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.model.LatLng
import com.google.android.libraries.maps.model.MarkerOptions
import com.google.android.libraries.maps.model.PolylineOptions
import com.google.maps.android.ktx.awaitMap
//import com.jetpack.googlemap.ui.theme.GoogleMapTheme


@Composable
fun mapScreen(navController: NavController, services: String?, datetime: String?, lat: String, long: String) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val scrollPageState = rememberScrollState()
    Box(modifier = Modifier.fillMaxSize()) {
        Column() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .padding(10.dp)
            ) {
                //myMap(){}
                GoogleMap2(lat, long)
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                elevation = 10.dp
            ) {
                var text by remember { mutableStateOf(TextFieldValue("")) }
                OutlinedTextField(
                    value = text,
                    label = { Text(text = "type your location") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    onValueChange = {
                        text = it
                    }
                )
            }
            Text(text = "${services} + ${datetime}")
        }

        Row(modifier = Modifier
            .width(screenWidth / 2)
            .align(Alignment.BottomStart)
            .padding(start = 10.dp, bottom = 10.dp)
            .horizontalScroll(scrollPageState)
        ) {
            pagerButtons(pageNo = 3, navController = navController, services, null)
        }
        Button(onClick = {
                         navController.navigate("confirmation/${services}/${datetime}/Parkhill Residence")
        }, modifier = Modifier
            .width(screenWidth / 2)
            .align(Alignment.BottomEnd)
            .padding(10.dp)) {
            Text(text = "Next")
        }
    }

}

@Composable
fun myMap(
    modifier: Modifier = Modifier,
    onReady:(GoogleMap) -> Unit
) {
    val context = LocalContext.current

    val mapView = remember{
        MapView(context)
    }

    val lifecycle = LocalLifecycleOwner.current.lifecycle

    lifecycle.addObserver(rememberMapLifeCycle(map = mapView))

    AndroidView(
        factory = {
                  mapView.apply {
                      mapView.getMapAsync{ googleMap ->
                          onReady(googleMap)
                      }
                      //TODO: add location functions here
                  }
        },
        modifier = Modifier
    )
}

@Composable
fun rememberMapLifeCycle(map:MapView):LifecycleEventObserver{
    return remember{
        LifecycleEventObserver( { source, event ->
            when(event){
                Lifecycle.Event.ON_CREATE -> map.onCreate(Bundle())
                Lifecycle.Event.ON_START -> map.onStart()
                Lifecycle.Event.ON_RESUME -> map.onResume()
                Lifecycle.Event.ON_PAUSE -> map.onPause()
                Lifecycle.Event.ON_STOP -> map.onStop()
                Lifecycle.Event.ON_DESTROY -> map.onDestroy()
                Lifecycle.Event.ON_ANY -> throw IllegalStateException()
            }
        })
    }
}