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
        return players.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.player_item, parent, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val playerItem = players[position]

        holder.nameAndNumber.text = "${playerItem.name} (${playerItem.number})"
        holder.positionAndAge.text = "${playerItem.position}, ${playerItem.age} y.o."
        holder.matches.text = "M: ${playerItem.match_played}"
        holder.goals.text = "G: ${playerItem.goals}"
        holder.yc.text = "YC: ${playerItem.yellow_cards}"
        holder.rc.text = "RC: ${playerItem.red_cards}"

        Picasso.get().load(playerItem.image).placeholder(R.drawable.placeholder).into(holder.photo)
    }

    class PlayerViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameAndNumber: TextView = itemView.findViewById(R.id.player_name_and_number)
        val positionAndAge: TextView = itemView.findViewById(R.id.player_position_and_age)
        val matches: TextView = itemView.findViewById(R.id.matches)
        val goals: TextView = itemView.findViewById(R.id.goals)
        val yc: TextView = itemView.findViewById(R.id.yc)
        val rc: TextView = itemView.findViewById(R.id.rc)
        val photo: ImageView = itemView.findViewById(R.id.player_photo)

        fun getContext(): Context {
            return itemView.context
        }
    }
}
