package com.example.midtermexam_posts.adapters


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.midtermexam_posts.R
import com.example.midtermexam_posts.activities.CommentActivity
import com.example.midtermexam_posts.api.dto.Post
import kotlinx.android.synthetic.main.post_item.view.*

class PostAdapter(private var posts: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        private lateinit var post: Post

        fun bind(post: Post) {

            this.post = post

            itemView.title.text = post.title
            itemView.postTextView.text = post.body
        }

        override fun onClick(view: View?) {
            val context = itemView.context
            val intent = Intent(context, CommentActivity::class.java)
            intent.putExtra("id", post.id)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent,  false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    fun updatePosts(posts: List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

}