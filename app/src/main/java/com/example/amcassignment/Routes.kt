package com.example.amcassignment

sealed class Routes(val route: String){
    object Home: Routes("home")
    object Reservation: Routes("reservation")
    object DateTime: Routes("datetime")
    object Maps: Routes("maps")
    object Confirmation: Routes("confirmation")
    object Rating: Routes("rating")
    object Profile: Routes("profile")
}
