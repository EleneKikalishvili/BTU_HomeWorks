package com.example.midtermexam_posts

import android.app.Application
import com.example.midtermexam_posts.api.RetrofitClient

class App : Application( ){
    override fun onCreate() {
        super.onCreate()
        RetrofitClient.initClient()
    }
}