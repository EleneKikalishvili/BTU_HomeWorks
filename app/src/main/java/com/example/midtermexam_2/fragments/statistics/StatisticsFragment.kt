package com.example.midtermexam_2.fragments.statistics

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.midtermexam_2.App
import com.example.midtermexam_2.R
import kotlinx.android.synthetic.main.fragment_statistics.*
import kotlin.math.roundToInt

class StatisticsFragment : Fragment(R.layout.fragment_statistics) {

    private var sumOfExerciseHours:Long = 0
    private var sumOfWaterLiters:Long = 0
    private var avgOfSleep:Double = 0.0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = App.instance.db.getDayDao()
        sumOfExerciseHours = db.getSumOfExercises()
        sumOfWaterLiters = db.getSumOfWater()
        avgOfSleep = db.getAvgSleep()
        avgOfSleep = (avgOfSleep*100).roundToInt()/100.0

        var total = "Exercising Total - $sumOfExerciseHours Hours"
        totalHoursOfExercising.text = total

        var total2 = "Water Total - $sumOfWaterLiters Liters"
        totalAmountOfWater.text= total2

        var avg = "Average Sleep - $avgOfSleep Hours"
        averageHoursOfSleep.text = avg
    }


}
