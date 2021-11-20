package com.example.amcassignment.screens

import android.os.Bundle
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import java.lang.IllegalStateException

@Composable
fun mapScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
                .clip(RoundedCornerShape(24.dp))
                .padding(10.dp)
        ) {
            myMap(){}
        }
        Button(onClick = {
                         navController.navigate("confirmation")
        }, modifier = Modifier.align(Alignment.BottomEnd).padding(10.dp)) {
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