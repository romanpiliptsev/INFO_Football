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
import com.example.infofootball.data.TableItem
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.squareup.picasso.Picasso

class TableAdapter(private val tableItems: List<TableItem>) : RecyclerView.Adapter<TableAdapter.TableViewHolder>() {

    override fun getItemCount(): Int {
        return tableItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.table_item, parent, false)
        return TableViewHolder(view)
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        val tableItem = tableItems[position]

        val logo = tableItem.logo
        if (logo.endsWith("svg")) {
            GlideToVectorYou
                .init()
                .with(holder.getContext())
                .load(Uri.parse(logo), holder.logo)
        } else {
            Picasso.get().load(logo).into(holder.logo)
        }

        holder.position.text = tableItem.position.toString()
        holder.name.text = tableItem.name
        holder.games.text = tableItem.playedGames.toString()
        holder.wins.text = tableItem.won.toString()
        holder.draws.text = tableItem.draw.toString()
        holder.defeat.text = tableItem.lost.toString()
        val diff = (tableItem.goalsFor - tableItem.goalsAgainst).toString()
        holder.difference.text = if (diff.startsWith("-") || diff == "0") diff else "+$diff"
        holder.points.text = tableItem.points.toString()
    }

    class TableViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val position: TextView = itemView.findViewById(R.id.position)
        val logo: ImageView = itemView.findViewById(R.id.logo)
        val name: TextView = itemView.findViewById(R.id.name)
        val games: TextView = itemView.findViewById(R.id.games)
        val wins: TextView = itemView.findViewById(R.id.wins)
        val draws: TextView = itemView.findViewById(R.id.draws)
        val defeat: TextView = itemView.findViewById(R.id.defeat)
        val difference: TextView = itemView.findViewById(R.id.difference)
        val points: TextView = itemView.findViewById(R.id.points)

        fun getContext(): Context {
            return itemView.context
        }
    }
}
