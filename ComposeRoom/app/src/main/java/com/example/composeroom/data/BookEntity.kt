package com.example.composeroom.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BookEntity(

    @PrimaryKey(autoGenerate = true)
    val id : Int,

    val bookName : String
)
