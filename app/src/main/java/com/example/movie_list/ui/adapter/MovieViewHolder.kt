package com.example.movie_list.ui.Movies

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie_list.Model.Communication
import com.example.movie_list.Model.Remote.NowShowing
import com.example.movie_list.Model.Remote.Result
import com.example.movie_list.R
import kotlinx.android.synthetic.main.now_showing_item_layout.view.*

class MovieViewHolder(val view: View, val communication: Communication) : RecyclerView.ViewHolder(view) {


    fun setData(result: Result) {
        Glide.with(view.Now_Show_poster_Image).load("https://image.tmdb.org/t/p/w500${result.posterPath}")
            .into(view.Now_Show_poster_Image)

        view.Now_Show_poster_Image.setOnClickListener {
            communication.itemClicked(result)
        }
    }





}