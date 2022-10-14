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
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {

    }

    class MatchViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}
