package com.example.amcassignment.model

data class Rating(
    val Id: Int,
    val star: Int,
    val review: String,
    val imageLink: String,
    val service_id: Int
)
