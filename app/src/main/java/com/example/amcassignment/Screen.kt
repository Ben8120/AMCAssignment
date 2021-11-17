package com.example.amcassignment

//this is a nav host controller
sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object Detail: Screen(route = "detailed_show_screen")
}
