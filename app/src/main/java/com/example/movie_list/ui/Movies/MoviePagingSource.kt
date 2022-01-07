package com.example.movie_list.ui.Movies

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.movie_list.Model.Remote.Result
import com.example.movie_list.Model.NetworkHelper

class MoviePagingSource : PagingSource<Int,Result>() {

    private val apiService = NetworkHelper.apiService()

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val pageNumber = params.key ?: 1
        val ResponceData = apiService.getMoviePageByPage(pageNumber)
        val movieList : List<Result> = ResponceData.results
        return  try {
            LoadResult.Page(
                data = movieList,
                prevKey = null,
                nextKey = if (movieList.isEmpty()) null else pageNumber + 1
            )
        }
        catch (execption : Exception){
            LoadResult.Error(execption)
        }
    }


    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition
    }




}



