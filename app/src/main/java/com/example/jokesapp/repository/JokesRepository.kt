package com.example.jokesapp.repository

import androidx.lifecycle.MutableLiveData
import com.example.jokesapp.models.Joke
import com.example.jokesapp.network.APIService
import javax.inject.Inject


class JokesRepository @Inject constructor(val apiService: APIService) {


    private val _jokeLiveData = MutableLiveData<Joke>()
    val jokeLiveData get() = _jokeLiveData

    private val jokes: MutableList<Joke> = mutableListOf()

    suspend fun fetchJoke(): Joke {
        val joke = apiService.getJoke()
        jokes.add(joke)
        if (jokes.size > 10)
            jokes.removeAt(0)
        return joke
    }

    fun getJokes(): List<Joke> = jokes


   /* suspend fun getJoke() {
            val response = apiService.getJoke()

        if(response.isSuccessful && response.body()!=null){
            _jokeLiveData.postValue(response.body())
        }
    }*/


}