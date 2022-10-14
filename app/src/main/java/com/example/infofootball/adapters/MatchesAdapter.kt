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
import com.example.infofootball.data.Match
import com.example.infofootball.data.Team
import com.example.infofootball.utils.JSONUtils
import com.example.infofootball.utils.NetworkUtils
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.squareup.picasso.Picasso

class MatchesAdapter(private val matches: List<Match>, private val team: Team?, private val name: String?)
    : RecyclerView.Adapter<MatchesAdapter.MatchViewHolder>() {

    override fun getItemCount(): Int {
        return matches.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.match_item, parent, false)
        return MatchViewHolder(view)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val matchItem = matches[position]

        if(matchItem.homeTeamKey == team?.team_key) {
            holder.firstTeamName.text = name
            holder.secondTeamName.text = matchItem.awayTeam
            var logo: String? = team.team_logo

            if (logo?.endsWith("svg") == true) {
                GlideToVectorYou
                    .init()
                    .with(holder.getContext())
                    .load(Uri.parse(logo), holder.firstTeamLogo)
            } else {
                Picasso.get().load(logo).into(holder.firstTeamLogo)
            }

            logo = JSONUtils.getTeamFromJSON(NetworkUtils.getJSONForTeam(matchItem.awayTeamKey))
                ?.team_logo

            if (logo?.endsWith("svg") == true) {
                GlideToVectorYou
                    .init()
                    .with(holder.getContext())
                    .load(Uri.parse(logo), holder.secondTeamLogo)
            } else {
                Picasso.get().load(logo).into(holder.secondTeamLogo)
            }
        } else {
            holder.firstTeamName.text = matchItem.homeTeam
            holder.secondTeamName.text = name
            var logo: String? = team?.team_logo

            if (logo?.endsWith("svg") == true) {
                GlideToVectorYou
                    .init()
                    .with(holder.getContext())
                    .load(Uri.parse(logo), holder.secondTeamLogo)
            } else {
                Picasso.get().load(logo).into(holder.secondTeamLogo)
            }

            logo = JSONUtils.getTeamFromJSON(NetworkUtils.getJSONForTeam(matchItem.homeTeamKey))
                ?.team_logo

            if (logo?.endsWith("svg") == true) {
                GlideToVectorYou
                    .init()
                    .with(holder.getContext())
                    .load(Uri.parse(logo), holder.firstTeamLogo)
            } else {
                Picasso.get().load(logo).into(holder.firstTeamLogo)
            }
        }

        holder.result.text = matchItem.finalResult
    }

    class MatchViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstTeamLogo: ImageView = itemView.findViewById(R.id.first_team_logo)
        val firstTeamName: TextView = itemView.findViewById(R.id.first_team_name)
        val secondTeamLogo: ImageView = itemView.findViewById(R.id.second_team_logo)
        val secondTeamName: TextView = itemView.findViewById(R.id.second_team_name)
        val result: TextView = itemView.findViewById(R.id.result)

        fun getContext(): Context {
            return itemView.context
        }
    }
}
