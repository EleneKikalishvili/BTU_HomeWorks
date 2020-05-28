package com.example.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "NOTES")
data class Note (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "NoteID")
    val noteId: Long,
    @ColumnInfo(name = "NoteText")
    val noteText: String?
)

