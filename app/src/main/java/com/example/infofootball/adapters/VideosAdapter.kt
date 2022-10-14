package com.example.infofootball.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.infofootball.R
import com.example.infofootball.data.Video

class VideosAdapter(private val videos: List<Video>)
    : RecyclerView.Adapter<VideosAdapter.VideoViewHolder>() {

    override fun getItemCount(): Int {
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(parent)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {

    }

    class VideoViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}
