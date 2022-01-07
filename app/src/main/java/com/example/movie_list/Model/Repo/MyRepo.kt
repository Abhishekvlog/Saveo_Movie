package com.example.movie_list.Model.Repo

import androidx.lifecycle.MutableLiveData
import com.example.movie_list.Model.ApiClient
import com.example.movie_list.Model.Network
import com.example.movie_list.Model.Remote.ComingSoon
import com.example.movie_list.Model.Remote.NowShowing
import com.example.movie_list.Model.Remote.ResponseDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MyRepo {
    val apiClient = Network.getInstance().create(ApiClient::class.java)

    val DataList = MutableLiveData<ResponseDTO>()
    val mutableList1 = MutableLiveData<List<ComingSoon>>()
    val mutableList2 = MutableLiveData<List<NowShowing>>()


    fun getApi(){
        CoroutineScope(Dispatchers.IO).launch{
           mutableList1.postValue(apiClient.getMovie().comingSoon)
           mutableList2.postValue(apiClient.getMovie().nowShowing)
        }

    }
    fun getdata(){
        CoroutineScope(Dispatchers.IO).launch {
            DataList.postValue(apiClient.getMovie())
        }
    }







}