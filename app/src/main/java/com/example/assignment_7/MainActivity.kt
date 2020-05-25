package com.example.assignment_7

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.system.Os.bind
import android.text.TextUtils
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.note_item.*

class MainActivity : AppCompatActivity() {
    var notes: MutableSet<String> = mutableSetOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myAdapter = NoteListAdapter(this, notes.toMutableList())

        val sharedPreferences=getSharedPreferences("MyApplication", Context.MODE_PRIVATE)
        val savedText =  sharedPreferences.getStringSet("NOTE", setOf<String>())
        if(savedText != null){
            notes = savedText.toMutableSet()
        }

        addBtn.setOnClickListener {

            val input = inputText.text.toString()

            if (!TextUtils.isEmpty(input)) {
                notes.add(input)
                myAdapter.add(input)
                myAdapter.notifyDataSetChanged()
                inputText.setText("")
               sharedPreferences.edit().putStringSet("NOTE", notes).apply()
            }
        }

        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}
