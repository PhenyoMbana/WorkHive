package com.example.workhive

data class Gig(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val category: String = "",
    val budget: String = "",
    val location: String = "",
    val postedBy: String = "",
    val postedTime: String = "",
    val duration: String = "",
    val userAvatar: Int = R.drawable.ic_person_placeholder
)