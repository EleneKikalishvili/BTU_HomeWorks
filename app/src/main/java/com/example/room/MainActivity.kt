package com.example.room

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private  val notes: MutableList<String> = mutableListOf()
    private lateinit var dbNotes: List<Note>
    private lateinit var myAdapter: NoteListAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setSupportActionBar(toolbar)

        myAdapter = NoteListAdapter(this, notes)

        dbNotes = App.instance.db.getNoteDao().getAll()
        dbNotes.asReversed().forEach {
            notes.add(it.noteText.toString())
        }

        addBtn.setOnClickListener {

            val input = inputText.text.toString()

            if (!TextUtils.isEmpty(input)) {
                myAdapter.add(input)
                App.instance.db.getNoteDao().insert(Note(0,input))
                inputText.setText("")
            }
        }


        recycler.adapter = myAdapter
        recycler.layoutManager = LinearLayoutManager(this)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_delete, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        App.instance.db.getNoteDao().deleteAll()
        myAdapter.update(mutableListOf())
        return super.onOptionsItemSelected(item)
    }

}
