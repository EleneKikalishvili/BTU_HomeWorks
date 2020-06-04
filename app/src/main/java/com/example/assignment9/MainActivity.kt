package com.example.assignment9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignment9.adapters.ViewPagerFragmentAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewPagerFragmentAdapter: ViewPagerFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPagerFragmentAdapter = ViewPagerFragmentAdapter(this)

        viewpager.adapter = viewPagerFragmentAdapter

        TabLayoutMediator(tabLayout, viewpager) { tab, position ->
           when(position) {
               0 -> tab.setIcon(R.drawable.ic_group_black_24dp)
               1 -> tab.setIcon(R.drawable.ic_contact_phone_black_24dp)
               2 -> tab.setIcon(R.drawable.ic_library_music_black_24dp)
           }
        }.attach()

    }

}
