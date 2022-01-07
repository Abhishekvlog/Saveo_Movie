package com.example.movie_list.Model.Repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.movie_list.ui.Movies.MoviePagingSource

class MoviePagerRepository {

    fun getPageList()  =
        Pager(config = PagingConfig(
            pageSize = 21
//            maxSize = 100
        ),
            pagingSourceFactory = { MoviePagingSource() }
        ).liveData
}