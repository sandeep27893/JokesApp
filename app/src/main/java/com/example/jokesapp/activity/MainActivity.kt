package com.example.jokesapp.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.ui.AppBarConfiguration
import com.example.jokesapp.databinding.ActivityMainBinding
import com.example.jokesapp.models.Joke
import com.example.jokesapp.viewmodels.JokesViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: JokeAdapter


    private val jokesViewModel by viewModels<JokesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)

        //jokesViewModel.getJoke()

/*        binding.recyclerView.layoutManager =
            LinearLayoutManager(this)*/
        adapter = JokeAdapter()
        binding.recyclerView.adapter = adapter



  //      adapter.notifyDataSetChanged()
     /*   jokesViewModel.jokeLiveData.observe(this, Observer {
            binding.textView.text = it.toString()
        })
*/

        jokesViewModel.jokes.observe(this@MainActivity, Observer {
                jokes -> adapter.submitList(jokes)
            adapter.notifyDataSetChanged()
        })


        val timer = Timer()
        val hourlyTask: TimerTask = object : TimerTask() {
            override fun run() {
                jokesViewModel.fetchJoke()

            }
        }

        timer.schedule(hourlyTask, 0L ,1000*20)

    }


}

