package com.example.jokesapp.network

import com.example.jokesapp.models.Joke
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module  //   it informs Hilt how to provide instances of certain types { For example, you cannot constructor-inject an interface.
// You also cannot constructor-inject a type that you do not own, such as a class from an external library.}
@InstallIn(SingletonComponent::class) // To tell Hilt which Android class each module will be used or installed in.
class RetrofitModule {


    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit.Builder {
        return Retrofit.Builder().baseUrl("https://geek-jokes.sameerkumar.website")
            .addConverterFactory(GsonConverterFactory.create())
        }

    @Singleton
    @Provides
    fun jokesAPI(retrofit : Retrofit.Builder) : APIService {
        return retrofit.build().create(APIService::class.java)
    }

}