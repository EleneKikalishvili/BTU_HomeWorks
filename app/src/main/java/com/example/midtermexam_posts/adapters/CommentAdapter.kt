package com.example.midtermexam_posts.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.midtermexam_posts.R
import com.example.midtermexam_posts.api.dto.Comment
import kotlinx.android.synthetic.main.comment_item.view.*

class CommentAdapter(private  var comments: List<Comment>) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>(){

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private  lateinit var com: Comment

        fun bind(com: Comment) {

            this.com = com

            itemView.email.text = com.email
            itemView.commentTextView.text = com.body

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_item, parent, false)
        return CommentViewHolder(view)
    }

    override fun getItemCount(): Int = comments.size

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(comments[position])
    }

    public fun updateUI(comments: List<Comment>){
        this.comments = comments
        notifyDataSetChanged()
    }
}