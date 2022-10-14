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
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopScorerViewHolder {
        return TopScorerViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TopScorerViewHolder, position: Int) {
    }

    class TopScorerViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}
