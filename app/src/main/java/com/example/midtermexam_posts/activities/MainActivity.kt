package com.example.midtermexam_posts.activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midtermexam_posts.R
import com.example.midtermexam_posts.adapters.PostAdapter
import com.example.midtermexam_posts.api.RetrofitClient

import com.example.midtermexam_posts.api.dto.Post
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.initRecycler()
        this.getAllPosts()
    }

    private fun initRecycler() {
        val layoutManager = LinearLayoutManager(this)
        postList.layoutManager = layoutManager
        postAdapter = PostAdapter(ArrayList())
        postList.adapter = postAdapter
    }

    private fun getAllPosts() {

        RetrofitClient.reqResApi.getPosts().enqueue(object : Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if(response.isSuccessful && response.body() != null) {
                    postAdapter.updatePosts(response.body()!!)
                }
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }
}
