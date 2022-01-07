package com.example.movie_list.Model.Remote


import com.google.gson.annotations.SerializedName

data class ResponseDTO(
    @SerializedName("coming_soon")
    val comingSoon: List<ComingSoon>,
    @SerializedName("now_showing")
    val nowShowing: List<NowShowing>
)