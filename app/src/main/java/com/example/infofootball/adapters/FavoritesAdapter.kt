package com.example.infofootball.adapters

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.infofootball.R
import com.example.infofootball.data.DBTeam
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.squareup.picasso.Picasso

class FavoritesAdapter(private val teams: List<DBTeam>)
    : RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>() {

    override fun getItemCount(): Int {
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {

        return FavoritesViewHolder(parent)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {

    }

    class FavoritesViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}
