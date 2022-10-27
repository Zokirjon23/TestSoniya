package com.example.testsoniya.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.testsoniya.databinding.ItemLoadingStateBinding

class LoadStateAdapter(var retry: (() -> Unit)? = null): androidx.paging.LoadStateAdapter<LoadStateAdapter.LoadStateViewHolder>()  {



    inner class LoadStateViewHolder(
        private val binding: ItemLoadingStateBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(loadState: LoadState) {
            if (loadState is LoadState.Error) {
                binding.textViewError.text = loadState.error.localizedMessage
            }

            binding.progressbar.isVisible = (loadState is LoadState.Loading)
            binding.buttonRetry.isVisible = (loadState is LoadState.Error)
            binding.textViewError.isVisible = (loadState is LoadState.Error)
            binding.buttonRetry.setOnClickListener {
                retry?.invoke()
            }

            binding.progressbar.visibility = View.VISIBLE
        }
    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState)= LoadStateViewHolder(
        ItemLoadingStateBinding.inflate(LayoutInflater.from(parent.context), parent, false))

//    fun setRetryClickListener(f :()-> Unit){
//        retry = f
//    }
}