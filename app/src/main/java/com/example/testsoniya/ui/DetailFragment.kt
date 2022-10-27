package com.example.testsoniya.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.testsoniya.R
import com.example.testsoniya.adapter.EpisodeAdapter
import com.example.testsoniya.databinding.FragmentDetailBinding
import com.example.testsoniya.presenter.DetailViewModel
import com.example.testsoniya.presenter.impl.DetailViewModelImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val viewModel : DetailViewModel by viewModels<DetailViewModelImpl>()
    private val args : DetailFragmentArgs by navArgs()
    private val binding by viewBinding(FragmentDetailBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenStarted {
            viewModel.initUi.collectLatest {
                val result= args.itemData
                binding.apply {
                    Glide.with(requireContext()).load(result.image).error(R.drawable.error).into(avatar)
                    name.text = result.name
                    status.text = result.status
                    specie.text = result.species
                    type.text = result.type.ifEmpty { "none" }
                    gender.text = result.gender
                    originName.text = result.origin.name
                    originUrl.text = result.origin.url
                    location.text = result.location.name
                    locationUrl.text = result.location.url
                    created.text = result.created
                    binding.episodeList.adapter = EpisodeAdapter(result.episode)
                }
            }
        }
    }
}