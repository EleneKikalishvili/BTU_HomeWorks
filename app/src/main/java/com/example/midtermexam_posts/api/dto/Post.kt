package com.example.midtermexam_posts.api.dto

data class Post(
    val userId: Long,
    val id: Long,
    val title: String,
    val body: String
)