package com.example.movie_list.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.movie_list.Model.Communication
import com.example.movie_list.Model.Remote.Result
import com.example.movie_list.R
import com.example.movie_list.ui.Movies.MovieViewHolder

class MovieAdapter(val communication: Communication) : PagingDataAdapter<Result, MovieViewHolder>(diffUtil) {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id

            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.equals(newItem)

            }

        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        var result = getItem(position)
        result?.let {
            Log.d("abc",it.title)
            holder.setData(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.now_showing_item_layout, parent, false)
        return MovieViewHolder(view,communication)
    }

}