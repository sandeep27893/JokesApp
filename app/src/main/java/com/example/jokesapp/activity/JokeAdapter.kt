package com.example.jokesapp.activity

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jokesapp.databinding.ListItemBinding
import com.example.jokesapp.models.Joke

class JokeAdapter() :
    ListAdapter<Joke, JokeAdapter.JokeViewHolder>(ComparatorDiffUtil()) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        /* val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
         return JokeViewHolder(itemView)*/
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JokeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke = getItem(position)
        holder.bind(joke.joke)
    }

    inner class JokeViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        //    private val jokeTextView: TextView = itemView.findViewById(R.id.textView)

        fun bind(joke: String) {
            Log.d("Joke" , joke)

            binding.textView.text = joke
        }
    }

    class ComparatorDiffUtil : DiffUtil.ItemCallback<Joke>() {
        override fun areItemsTheSame(oldItem: Joke, newItem: Joke): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Joke, newItem: Joke): Boolean {
            return oldItem == newItem
        }
    }
}