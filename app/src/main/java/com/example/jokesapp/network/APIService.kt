package com.example.jokesapp.network

import com.example.jokesapp.models.Joke
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {

    @GET("/api?format=json")
    suspend fun getJoke() : Joke

}