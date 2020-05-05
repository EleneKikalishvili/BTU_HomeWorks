package com.example.midtermexam_posts.api


import com.example.midtermexam_posts.api.dto.Comment
import com.example.midtermexam_posts.api.dto.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ReqResService {
    @GET("/posts")
    fun getPosts() : Call<List<Post>>

    @GET("/posts/{id}/comments")
    fun getComments(@Path("id") id: Long): Call<List<Comment>>
}