package com.example.midtermexam_posts.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midtermexam_posts.R
import com.example.midtermexam_posts.adapters.CommentAdapter
import com.example.midtermexam_posts.api.RetrofitClient
import com.example.midtermexam_posts.api.dto.Comment
import kotlinx.android.synthetic.main.activity_comment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentActivity : AppCompatActivity() {

    private lateinit var commentAdapter: CommentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        this.initRecycler()

        val postId = intent.extras?.getLong("id")

        if (postId != null) {
            RetrofitClient.reqResApi.getComments(postId).enqueue(object : Callback<List<Comment>>{
                override fun onFailure(call: Call<List<Comment>>, t: Throwable) {

                }

                override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                    if (response.isSuccessful && response.body() != null) {
                        commentAdapter.updateUI(response.body()!!)
                    }
                }


            })
        }
    }

    private fun initRecycler() {
        val layoutManager = LinearLayoutManager(this)
        comList.layoutManager = layoutManager
        commentAdapter = CommentAdapter(ArrayList())
        comList.adapter = commentAdapter
    }

}
