package com.example.workhive

data class User(
    val userId: String = "",
    val fullName: String = "",
    val email: String = "",
    val phone: String = "",
    val profilePictureUrl: String = "",
    val bio: String = "",
    val language: String = "english",
    val rating: Float = 0.0f
)