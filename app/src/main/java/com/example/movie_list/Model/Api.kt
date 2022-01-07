package com.example.movie_list.Model

import com.example.movie_list.Model.Remote.ResponceData
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    // https://api.themoviedb.org/3/discover/movie?api_key=328c283cd27bd1877d9080ccb1604c91&sort_by=popularity.desc

    @GET("3/discover/movie?api_key=328c283cd27bd1877d9080ccb1604c91&sort_by=popularity.desc")
    suspend fun getMoviePageByPage(@Query("page") page : Int ) : ResponceData
}