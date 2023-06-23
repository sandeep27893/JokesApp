package com.example.jokesapp.localdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jokesapp.models.Joke

@Dao
interface JokeDAO {

    @Query("select * from joke_table")
    suspend fun getAllJokes(): List<Joke>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJokes(joke: Joke)

    @Query("DELETE FROM joke_table WHERE id = :jokeId")
    suspend fun removeJokes(jokeId: Long)
}