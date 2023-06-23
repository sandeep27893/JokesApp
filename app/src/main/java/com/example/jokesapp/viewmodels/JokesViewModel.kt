package com.example.jokesapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jokesapp.models.Joke
import com.example.jokesapp.repository.JokesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokesViewModel @Inject constructor(private val jokesRepository: JokesRepository) : ViewModel() {


       /* val jokeLiveData get()  = jokesRepository.jokeLiveData

         fun getJoke() {
                viewModelScope.launch {
                        jokesRepository.getJoke()
                }
         }*/

    private val _jokes: MutableLiveData<List<Joke>> = MutableLiveData()
    val jokes: LiveData<List<Joke>> get() = _jokes

    fun fetchJoke() {
        viewModelScope.launch {
             jokesRepository.fetchJoke()
            _jokes.value = jokesRepository.getJokes()
        }
    }


}