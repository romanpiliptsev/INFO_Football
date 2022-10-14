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
        return teams.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.favorite_item, parent, false)
        return FavoritesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        val favoriteItem = teams[position]

        val logo = favoriteItem.getTeamLogo()

        if (logo.endsWith("svg")) {
            GlideToVectorYou
                .init()
                .with(holder.getContext())
                .load(Uri.parse(logo), holder.favoriteLogo)
        } else {
            Picasso.get().load(logo).into(holder.favoriteLogo)
        }

        holder.favoriteName.text = favoriteItem.getTeamName()
    }

    class FavoritesViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val favoriteLogo: ImageView = itemView.findViewById(R.id.favorite_logo)
        val favoriteName: TextView = itemView.findViewById(R.id.favorite_name)

        fun getContext(): Context {
            return itemView.context
        }
    }
}
