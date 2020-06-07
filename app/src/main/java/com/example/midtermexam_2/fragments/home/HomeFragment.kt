package com.example.midtermexam_2.fragments.home

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.midtermexam_2.App
import com.example.midtermexam_2.Day
import com.example.midtermexam_2.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        saveData.setOnClickListener {

            if (
                TextUtils.isEmpty(hoursOfExercising.text) ||
                TextUtils.isEmpty(amountOfWater.text) ||
                TextUtils.isEmpty(hoursOfSleep.text)
            ) {
                Toast.makeText(context, "fill out every field",
                    Toast.LENGTH_SHORT).show()
            } else {
                val day = Day(0,
                    hoursOfExercising.text.toString().toDouble(),
                    amountOfWater.text.toString().toDouble(),
                    hoursOfSleep.text.toString().toDouble()
                )

                App.instance.db.getDayDao().insert(day)

                hoursOfExercising.setText("")
                amountOfWater.setText("")
                hoursOfSleep.setText("")
            }
        }

    }

}
