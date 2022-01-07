package com.example.movie_list.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movie_list.Model.Remote.ComingSoon
import com.example.movie_list.R
import com.example.movie_list.ui.adapter.ComingSoonViewHolder

class ComingSoonAdapter(
    val comingList: MutableList<ComingSoon>) : RecyclerView.Adapter<ComingSoonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComingSoonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view1: View = inflater.inflate(R.layout.coming_soon_item_layout, parent, false)
        return ComingSoonViewHolder(view1)
    }

    override fun onBindViewHolder(holder: ComingSoonViewHolder, position: Int) {
        holder.setdata(comingList[position])
    }

    override fun getItemCount(): Int {
       return comingList.size
    }
}
