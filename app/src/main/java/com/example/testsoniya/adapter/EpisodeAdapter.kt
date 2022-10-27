package com.example.testsoniya.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testsoniya.R
import com.example.testsoniya.databinding.ItemEpisodeBinding

class EpisodeAdapter(private val list: List<String>) :
    RecyclerView.Adapter<EpisodeAdapter.EpisodeHolder>() {
    inner class EpisodeHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(link: String){
            binding.episodeText.text = "Episode ${bindingAdapterPosition+1}:"
            binding.episode.text = link
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EpisodeHolder(
        ItemEpisodeBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_episode,parent,false))
    )

    override fun onBindViewHolder(holder: EpisodeHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}