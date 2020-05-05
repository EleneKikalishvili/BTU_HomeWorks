package com.example.midtermexam_posts.api.dto

data class Comment(
    val postId: Long,
    val id: Long,
    val email: String,
    val body: String
)