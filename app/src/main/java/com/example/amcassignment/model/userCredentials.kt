package com.example.amcassignment.model

data class UserCredentials(
    val id: Int,
    val name: String,
    val email : String,
    val password: String,
    val isCleaner: Boolean
)
