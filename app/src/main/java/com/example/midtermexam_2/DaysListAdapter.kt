package com.example.midtermexam_2


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.day_item.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class DaysListAdapter( private val daysList: List<Day>): RecyclerView.Adapter<DaysListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): DaysListAdapter.ViewHolder {
        val myListItem = LayoutInflater.from(viewGroup.context).inflate(R.layout.day_item, viewGroup, false)
        return ViewHolder(myListItem)
    }

    inner class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(day: Day) {
            val dayNum = "Day N${day.dayId}"
            itemView.numberOfDay.text = dayNum
            val exercisingHours = "Exercising - ${day.hoursOfExercising} Hours"
            itemView.dailyHoursOfExercising.text = exercisingHours
            val amountOfWater = "Water - ${day.amountOfWater} Liter"
            itemView.dailyAmountOfWater.text = amountOfWater
            val sleepHours = "Sleep - ${day.hoursOfSleep} Hours"
            itemView.dailyHoursOfSleep.text = sleepHours

        }
    }

    override fun getItemCount(): Int {
        return daysList.count()
    }

    override fun onBindViewHolder(holder: DaysListAdapter.ViewHolder, position: Int) {
        holder.bind(daysList[position])
    }

}