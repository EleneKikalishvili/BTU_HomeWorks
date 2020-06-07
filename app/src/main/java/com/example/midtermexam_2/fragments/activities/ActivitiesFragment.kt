package com.example.midtermexam_2.fragments.activities


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midtermexam_2.App
import com.example.midtermexam_2.Day
import com.example.midtermexam_2.DaysListAdapter
import com.example.midtermexam_2.R
import kotlinx.android.synthetic.main.fragment_activities.*

class ActivitiesFragment : Fragment(R.layout.fragment_activities) {
    private lateinit var days: List<Day>
    private lateinit var myAdapter: DaysListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        days = App.instance.db.getDayDao().getAll()
        myAdapter = DaysListAdapter(days)

        allDaysActivitiesRecycler.adapter = myAdapter
        allDaysActivitiesRecycler.layoutManager = LinearLayoutManager(context)

    }
}
