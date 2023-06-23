package com.example.jokesapp.localdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jokesapp.models.Joke


@Database(entities = [Joke::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun jokeDao() : JokeDAO

    companion object {
        //The volatile keyword ensures that the variable is immediately visible to other threads.
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "jokes")
                .fallbackToDestructiveMigration()
                .build()
    }


}