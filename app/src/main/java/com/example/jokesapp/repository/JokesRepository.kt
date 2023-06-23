package com.example.jokesapp.repository

import androidx.lifecycle.MutableLiveData
import com.example.jokesapp.localdb.JokeDAO
import com.example.jokesapp.models.Joke
import com.example.jokesapp.network.APIService
import javax.inject.Inject


class JokesRepository @Inject constructor( val apiService: APIService, val jokeDao : JokeDAO) {


    /*private val _jokeLiveData = MutableLiveData<Joke>()
    val jokeLiveData get() = _jokeLiveData*/

    private val jokes: MutableList<Joke> = mutableListOf()

    suspend fun fetchJoke() {
        val joke = apiService.getJoke()
     //   jokes.add(joke)

        jokeDao.insertJokes(joke)
        if (jokeDao.getAllJokes().size > 10) {
            jokeDao.removeJokes(1)
        }
    }



   /* suspend fun getJokes(): List<Joke> {

         return jokeDao.getAllJokes()
    }*/

    suspend fun getJokes() = jokeDao.getAllJokes()



    /* suspend fun getJoke() {
             val response = apiService.getJoke()

         if(response.isSuccessful && response.body()!=null){
             _jokeLiveData.postValue(response.body())
         }
     }*/


}