package com.example.movie_list.ViewModel

import androidx.lifecycle.ViewModel
import com.example.movie_list.Model.Repo.MoviePagerRepository

class MovieViewModel : ViewModel() {
    private val repository = MoviePagerRepository()

    fun searchMovie()= repository.getPageList()

}