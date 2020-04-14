package com.example.homework_4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ProductAdapter (private  val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
       val view :View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val p:Product = products[position]

        holder.itemView.imageView.setImageResource(p.image)
        holder.itemView.title.text = p.title
        holder.itemView.description.text = p.description
        if(!p.isImportant) {
            holder.itemView.important.visibility = View.GONE
        }

    }

}