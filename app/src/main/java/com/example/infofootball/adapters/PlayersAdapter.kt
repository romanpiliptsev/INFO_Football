package com.example.infofootball.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.infofootball.R
import com.example.infofootball.data.Player
import com.squareup.picasso.Picasso

class PlayersAdapter(private val players: List<Player>)
    : RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder>() {

    override fun getItemCount(): Int {
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        return PlayerViewHolder(parent)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {

    }

    class PlayerViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}
