package com.example.testsoniya.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testsoniya.R
import com.example.testsoniya.data.model.Result
import com.example.testsoniya.databinding.ItemLoadingStateBinding
import com.example.testsoniya.databinding.ItemViewBinding

class MyListAdapter : PagingDataAdapter<Result, MyListAdapter.MyHolder>(MyDiffUtil()) {

    private var clickListener : ((Result)-> Unit)? = null


    inner class MyHolder(private val binding : ItemViewBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener { clickListener?.invoke(getItem(bindingAdapterPosition)!!) }
        }

        fun bind(result: Result){
            binding.name.text = result.name
            binding.imageView.apply {
                Glide.with(context).load(result.image).error(R.drawable.error).into(this)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyHolder(
        ItemViewBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false))
    )

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    class MyDiffUtil  : DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
           return oldItem == newItem
        }
    }

    fun setItemClickListener(f : (Result)-> Unit){
        clickListener = f
    }
}