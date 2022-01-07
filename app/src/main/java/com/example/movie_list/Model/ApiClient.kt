package com.example.movie_list.Model

import com.example.movie_list.Model.Remote.ResponseDTO
import retrofit2.http.GET

interface ApiClient {
    @GET("Dcosta2205/cd3bf4cfdf6911fb26ae95672adb468e/raw/62d68fac146598cdba379317011ac9aa1aca8621/movies_db")
    suspend fun getMovie(): ResponseDTO

}