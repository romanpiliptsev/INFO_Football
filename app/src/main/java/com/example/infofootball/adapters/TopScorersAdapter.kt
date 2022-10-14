package com.example.infofootball.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.infofootball.R
import com.example.infofootball.data.TopScorer

class TopScorersAdapter(private val topScorers: List<TopScorer>)
    : RecyclerView.Adapter<TopScorersAdapter.TopScorerViewHolder>() {

    override fun getItemCount(): Int {
        return topScorers.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopScorerViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.topscorer_item, parent, false)
        return TopScorerViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopScorerViewHolder, position: Int) {
        val topScorerItem = topScorers[position]

        holder.place.text = "${topScorerItem.place}"
        holder.name.text = topScorerItem.name
        holder.team.text = topScorerItem.teamName
        holder.goals.text = "GOALS: ${topScorerItem.goals}"
        holder.assists.text = "A: ${topScorerItem.assists}"
        holder.penGoals.text = "PEN: ${topScorerItem.penGoals}"

//        Picasso.get().load(JSONUtils.getPlayerPhotoFromJSON(NetworkUtils.getJSONForPlayer(topScorerItem.playerKey ?: 0))).placeholder(R.drawable.placeholder).into(holder.photo)
//        Picasso.get().load("asdasdasf.com/hahahahlol").placeholder(R.drawable.placeholder).into(holder.photo)
    }

    class TopScorerViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.topscorer_name)
        val team: TextView = itemView.findViewById(R.id.topscorer_team)
        val goals: TextView = itemView.findViewById(R.id.top_scorer_goals)
        val assists: TextView = itemView.findViewById(R.id.top_scorer_assists)
        val penGoals: TextView = itemView.findViewById(R.id.top_scorer_pen_goals)
        val place: TextView = itemView.findViewById(R.id.top_scorer_position)
//        val photo: ImageView = itemView.findViewById(R.id.top_scorer_player_photo)

        fun getContext(): Context {
            return itemView.context
        }
    }
}
