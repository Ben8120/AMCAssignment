package com.example.amcassignment.model

data class Reservations(
    val Id: Int,
    val services: String,
    val date: String,
    val time: String,
    val location: String,
    val client_id: Int,
    val cleaner_id: Int,
    val rating_id: Int,
    val isDonee: Boolean
)
