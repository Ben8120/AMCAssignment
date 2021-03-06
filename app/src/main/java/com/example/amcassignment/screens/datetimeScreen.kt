package com.example.amcassignment.screens

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun datetimeScreen(navController: NavController, services: String?) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val scrollPageState = rememberScrollState()
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "${services}")


        //datetimeComposable(context = LocalContext.current)
        val mYear: Int
        val mMonth: Int
        val mDay: Int
        val now = Calendar.getInstance()
        var dateStr: String
        var yearStr: String
        mYear = now.get(Calendar.YEAR)
        mMonth = now.get(Calendar.MONTH)
        mDay = now.get(Calendar.DAY_OF_MONTH)
        now.time = Date()
        val date = remember { mutableStateOf(" ") }
        val datePickerDialog = DatePickerDialog(
            LocalContext.current,
            { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                val cal = Calendar.getInstance()
                cal.set(year, month, dayOfMonth)
                //date.value = cal.time.toString()
                dateStr = cal.time.toString().substring(0..10)
                yearStr = cal.time.toString().substring(29..33)
                date.value = "$dateStr $yearStr"
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
                LocalContext.current,
                {_, hour: Int, minute: Int ->
                    time.value = "$hour:$minute"
                    date.value = date.value + " ${time.value}"

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
        }
        //end datetime composable

        Row(modifier = Modifier
            .width(screenWidth / 2)
            .align(Alignment.BottomStart)
            .padding(start = 10.dp, bottom = 10.dp)
            .horizontalScroll(scrollPageState)
        )  {
            pagerButtons(pageNo = 2, navController = navController, services, null)
        }
        val context = LocalContext.current
        Button(onClick = {
            if (date.value.isNullOrBlank()) {
                Toast.makeText(context, "Please provide date and time", Toast.LENGTH_SHORT).show()
            } else {
                navController.navigate( "maps/$services/${date.value}")
            }
        },
            modifier = Modifier
                .width(screenWidth / 2)
                .align(Alignment.BottomEnd)
                .padding(10.dp)
        ) {
            Text(text = "Next")
        }
    }
}

@Composable
fun datetimeComposable(context: Context) : String{
    val mYear: Int
    val mMonth: Int
    val mDay: Int
    val now = Calendar.getInstance()
    var dateStr: String
    var yearStr: String
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
            //date.value = cal.time.toString()
            dateStr = cal.time.toString().substring(0..10)
            yearStr = cal.time.toString().substring(29..33)
            date.value = dateStr+yearStr
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
    }
    return date.value
}

//can delete, no use anymore
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