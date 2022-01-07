package com.example.movie_list.Model.Remote


import com.google.gson.annotations.SerializedName

data class ComingSoon(
    @SerializedName("averageRating")
    val averageRating: Int,
    @SerializedName("contentRating")
    val contentRating: String,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("imdbRating")
    val imdbRating: String,
    @SerializedName("originalTitle")
    val originalTitle: String,
    @SerializedName("posterurl")
    val posterurl: String,
    @SerializedName("releaseDate")
    val releaseDate: String,
    @SerializedName("storyline")
    val storyline: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("video_url")
    val videoUrl: String,
    @SerializedName("year")
    val year: String
)