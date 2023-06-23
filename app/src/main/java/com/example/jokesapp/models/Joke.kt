package com.example.jokesapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "joke_table")
data class Joke(@PrimaryKey(autoGenerate = false) val id: Int?=null,
                val joke: String)