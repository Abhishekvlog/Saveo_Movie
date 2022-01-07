package com.example.movie_list.ui.Movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movie_list.Model.Communication
import com.example.movie_list.Model.Remote.ComingSoon
import com.example.movie_list.Model.Remote.Result
import com.example.movie_list.R
import com.example.movie_list.ViewModel.MainViewModel
import com.example.movie_list.ViewModel.MovieViewModel
import com.example.movie_list.ui.ComingSoonAdapter
import com.example.movie_list.ui.adapter.MovieAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() , Communication {

    lateinit var viewModel: MainViewModel
    lateinit var movieAdapter : MovieAdapter
    lateinit var movieViewModel : MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)

        viewModel.getMovie().observe(this, Observer {
            view_Pager_Main.adapter = ComingSoonAdapter(it.comingSoon as MutableList<ComingSoon>)
        })

        setAdapter()
        movieViewModel.searchMovie().observe(this, Observer {
            it.let {
                CoroutineScope(Dispatchers.IO).launch {
                    movieAdapter.submitData(it)
                    Log.d("abc" , it.toString())
                }
            }
        })


    }

    private fun setAdapter() {
        movieAdapter = MovieAdapter(this)
        val linearLayoutManager = GridLayoutManager(this,3)
        recycler_View_Main.apply {
            layoutManager = linearLayoutManager
            this.adapter = movieAdapter
        }
    }

    override fun itemClicked(result: Result) {
        val intent : Intent = Intent(this,Item_Activity::class.java)
        intent.putExtra("image",result.posterPath)
        intent.putExtra("name",result.title)
        intent.putExtra("detail",result.overview)
        intent.putExtra("date",result.releaseDate)
        intent.putExtra("rate",result.popularity)
        intent.putExtra("language",result.originalLanguage)
        startActivity(intent)

    }


}