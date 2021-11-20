package com.example.amcassignment.screens

import android.view.MotionEvent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amcassignment.R

@Composable
fun ratingScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Column {
            Text(text = "Review your cleaning session: No.000624", fontSize = 24.sp)
            ratingBar(rating = 1)
            reviewTextField("Tell us what you think")
            Text("Upload an image ")
            uploadImageButton()
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(text = "Confirm Review")
        }
    }
}

//https://github.com/w0rm1995/Jetpack-Compose-Rating-Bar
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ratingBar(
    modifier:Modifier = Modifier,
    rating: Int
) {
    var ratingState by remember {
        mutableStateOf(rating)
    }
    
    var selected by remember {
        mutableStateOf(false)
    }
    val size by animateDpAsState(targetValue = if (selected) 56.dp else 48.dp,
    spring(Spring.DampingRatioMediumBouncy))

    Row(
        modifier = Modifier.fillMaxWidth().padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ){
        for (i in 1..5) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_star),
                contentDescription = "star",
                modifier = modifier
                    .width(size)
                    .height(size)
                    .pointerInteropFilter {
                        when (it.action) {
                            MotionEvent.ACTION_DOWN -> {
                                selected = true
                                ratingState = i
                            }
                            MotionEvent.ACTION_UP -> {
                                selected = false
                            }
                        }
                        true
                    },
                tint = if (i <= ratingState) Color(0xFFFFD700) else Color(0xFFA2ADB1)
            )
        }
    }
}

@Composable
fun reviewTextField(label: String) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        label = { Text(text = label) },
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(10.dp),
        onValueChange = {
            text = it
        }
    )
}

@Composable
fun uploadImageButton() {
    Row(
    horizontalArrangement = Arrangement.SpaceEvenly,
    modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = {
            /*TODO*/
        },
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .padding(10.dp)
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_baseline_photo_camera), contentDescription = "uploadImage")
        }
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "imagePreview", modifier = Modifier
            .height(100.dp)
            .width(100.dp)
            .padding(10.dp))
    }
}