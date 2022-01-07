package com.example.movie_list.ui.Movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.movie_list.R
import kotlinx.android.synthetic.main.activity_item.*

class Item_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val image = intent.getStringExtra("image")

        Glide.with(this).load("https://image.tmdb.org/t/p/w500$image")
            .into(Image_View)

        val name = intent.getStringExtra("name")
        Movie_Name.setText(name)

        val mov_detail = intent.getStringExtra("detail")
        Movie_detail.setText(mov_detail)

        val release_date = intent.getStringExtra("date")
        Date_release.setText(release_date)

        val mov_lang = intent.getStringExtra("language")
        language_Movie.setText(mov_lang)

        val mov_rate = intent.getStringExtra("rate")
        popularity.setText(mov_rate)


        go_back.setOnClickListener {
            val intt = Intent(this,MainActivity::class.java)
            startActivity(intt)
        }


        Log.d("abcd", image.toString())
    }
}