package com.example.amcassignment.screens

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun datetimeScreen(navController: NavController) {
    Button(onClick = {
        navController.navigate( "maps")
    }) {
        Text(text = "Next")
    }
}

@Composable
fun datetimeComposable(context: Context) {
    val mYear: Int
    val mMonth: Int
    val mDay: Int
    val now = Calendar.getInstance()
    mYear = now.get(Calendar.YEAR)
    mMonth = now.get(Calendar.MONTH)
    mDay = now.get(Calendar.DAY_OF_MONTH)
    now.time = Date()
    val date = remember { mutableStateOf("") }
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            val cal = Calendar.getInstance()
            cal.set(year, month, dayOfMonth)
            date.value = cal.time.toString()
            //date.value = getFormattedDate(cal.time, "dd MMM,yyy")
        }, mYear, mMonth, mDay
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {
            Button(onClick = {
                datePickerDialog.show()
            },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Date Picker")
            }
            //Spacer(modifier = Modifier.size(16.dp))
            Text(text = "Selected date: ${date.value}", modifier = Modifier.padding(10.dp))
        }
        val calendar = Calendar.getInstance()
        val hour = calendar[Calendar.HOUR_OF_DAY]
        val minute = calendar[Calendar.MINUTE]

        val time = remember { mutableStateOf("")}
        val timePickerDialog = TimePickerDialog(
            context,
            {_, hour: Int, minute: Int ->
                time.value = "$hour:$minute"

            }, hour, minute, false
        )
        Row() {
            Button(onClick = {
                timePickerDialog.show()
            },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Time Picker")
            }
            Text(text = "Selected Time: ${time.value}", modifier = Modifier.padding(10.dp))
        }
        Button(onClick = {

        }) {
            Text(text = "Next")
        }
    }
}

@Composable
fun timeComposable(context: Context) {
    val calendar = Calendar.getInstance()
    val hour = calendar[Calendar.HOUR_OF_DAY]
    val minute = calendar[Calendar.MINUTE]

    val time = remember { mutableStateOf("")}
    val timePickerDialog = TimePickerDialog(
            context,
        {_, hour: Int, minute: Int ->
            time.value = "$hour:$minute"

        }, hour, minute, false
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Selected Time: ${time.value}")
        Spacer(modifier = Modifier.size(16.dp))
        Button(onClick = {
            timePickerDialog.show()
        }) {
            Text(text = "Open Time Picker")
        }
    }
    Button(onClick = { /*TODO*/ }, modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)) {
        Text(text = "Next")
    }
}