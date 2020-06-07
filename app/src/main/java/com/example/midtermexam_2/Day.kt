package com.example.midtermexam_2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DAYS")
data class Day(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "DayID")
    val dayId: Long,
    @ColumnInfo(name = "HoursOfExercising")
    val hoursOfExercising: Double,
    @ColumnInfo(name = "AmountOfWater")
    val amountOfWater: Double,
    @ColumnInfo(name = "HoursOfSleep")
    val hoursOfSleep: Double
)

