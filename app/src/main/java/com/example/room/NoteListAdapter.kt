package com.example.room

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull

import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.note_item.view.*

class NoteListAdapter(private val context: Context, private var myList: MutableList<String>): RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val myListItem = LayoutInflater.from(context).inflate(R.layout.note_item, viewGroup, false)
        return ViewHolder(myListItem)
    }

    override fun getItemCount(): Int {
        return myList.count()
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(myList[position])
    }


    inner class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(myItem: String){
            itemView.item.text = myItem
            itemView.setOnClickListener{
                Toast.makeText(context, myItem, Toast.LENGTH_LONG).show()
            }
        }
    }

    fun update(myList: MutableList<String>) {
        this.myList = myList
        notifyDataSetChanged()
    }

    fun add(note: String) {
        myList.add(0, note)
        notifyDataSetChanged()
    }
}