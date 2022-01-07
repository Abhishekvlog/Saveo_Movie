package com.example.movie_list.Model

import javax.xml.transform.Result

interface Communication {
    fun itemClicked(result : com.example.movie_list.Model.Remote.Result)
}