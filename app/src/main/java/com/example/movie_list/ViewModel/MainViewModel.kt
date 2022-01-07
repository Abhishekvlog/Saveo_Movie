package com.example.movie_list.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movie_list.Model.Remote.ResponseDTO
import com.example.movie_list.Model.Repo.MyRepo

class MainViewModel() : ViewModel(){
    val repo = MyRepo()

    fun getMovie(): MutableLiveData<ResponseDTO> {
        repo.getdata()

        return repo.DataList

    }

}