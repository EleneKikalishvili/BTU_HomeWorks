package com.example.midtermexam_2

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Day::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDayDao(): Dao
}