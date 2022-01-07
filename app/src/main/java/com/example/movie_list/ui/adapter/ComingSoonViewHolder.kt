package com.example.movie_list.ui.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie_list.Model.Remote.ComingSoon
import com.example.movie_list.R

class ComingSoonViewHolder(view : View) : RecyclerView.ViewHolder(view){
    var PosterImage : ImageView



    init {
        PosterImage = view.findViewById(R.id.coming_soon_poster_VP)


    }

    fun setdata(comingSoon: ComingSoon) {
        Glide.with(PosterImage).load(comingSoon.posterurl).into(PosterImage)

    }

}