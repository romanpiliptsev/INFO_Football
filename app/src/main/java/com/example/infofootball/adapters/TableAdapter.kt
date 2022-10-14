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
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        return TableViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {

    }

    class TableViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}
