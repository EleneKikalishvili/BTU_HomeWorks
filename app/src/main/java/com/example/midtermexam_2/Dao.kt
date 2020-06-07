package com.example.midtermexam_2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {
    @Query("SELECT * FROM DAYS")
    fun getAll(): List<Day>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg days: Day)

    @Query("DELETE FROM DAYS")
    fun deleteAll()

    @Query("SELECT sum(HoursOfExercising) FROM DAYS")
    fun getSumOfExercises():Long


    @Query("SELECT avg(HoursOfSleep) FROM DAYS")
    fun getAvgSleep():Double


    @Query("SELECT sum(AmountOfWater) FROM DAYS")
    fun getSumOfWater():Long
}