package com.example.homework_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.security.PKCS12Attribute

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ProductAdapter(getProducts())
        recycleView.layoutManager = GridLayoutManager(this, 2)
        recycleView.adapter = adapter
    }

    fun getProducts() : List<Product> {
        val p1 = Product(1, "Pizza al taglio", "pizza description", R.drawable.ic_local_pizza, false)
        val p2 = Product(2, "Pizza ai funghi", "pizza description", R.drawable.ic_local_pizza, false)
        val p3 = Product(3, "Pizzette", "pizza description", R.drawable.ic_local_pizza, false)
        val p4 = Product(4, "Pizza quattro formaggi", "pizza description", R.drawable.ic_local_pizza, false)
        val p5 = Product(5, "Pizza bianca", "pizza description", R.drawable.ic_local_pizza, false)
        val p6 = Product(6, "Pizza capricciosa", "pizza description", R.drawable.ic_local_pizza, false)
        val p7 = Product(7, "Caprese Pizza", "pizza description", R.drawable.ic_local_pizza, false)
        val p8 = Product(8, "Pizza marinara", "pizza description", R.drawable.ic_local_pizza, false)
        val p9 = Product(9, "Calzone Pizza", "pizza description", R.drawable.ic_local_pizza, false)
        val p10 = Product(10, "Pizza Margherita", "pizza description", R.drawable.ic_local_pizza, false)

        val returnList = ArrayList<Product>()

        returnList.add(p1)
        returnList.add(p2)
        returnList.add(p3)
        returnList.add(p4)
        returnList.add(p5)
        returnList.add(p6)
        returnList.add(p7)
        returnList.add(p8)
        returnList.add(p9)
        returnList.add(p10)

        return returnList

    }
}
