package com.example.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy


    @Dao
    interface NoteDao {

        @Query("SELECT * FROM NOTES")
        fun getAll(): List<Note>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insert(vararg notes: Note)

        @Query("DELETE FROM NOTES")
        fun deleteAll()
    }
