package com.example.testsoniya.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testsoniya.R
import com.example.testsoniya.adapter.LoadStateAdapter
import com.example.testsoniya.adapter.MyListAdapter
import com.example.testsoniya.databinding.FragmentMainScreenBinding
import com.example.testsoniya.presenter.MainScreenViewModel
import com.example.testsoniya.presenter.impl.MainScreenViewModelImpl
import com.muddassir.connection_checker.ConnectionState
import com.muddassir.connection_checker.ConnectivityListener
import com.muddassir.connection_checker.checkConnection
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainScreen : Fragment(R.layout.fragment_main_screen), ConnectivityListener {

    private val navController by lazy(LazyThreadSafetyMode.NONE) { findNavController() }
    private val binding by viewBinding(FragmentMainScreenBinding::bind)
    private val viewModel : MainScreenViewModel by viewModels<MainScreenViewModelImpl>()
    private val adapter = MyListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenStarted {
            viewModel.error.collectLatest {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.data.collectLatest {
                binding.listView.adapter = adapter.withLoadStateHeaderAndFooter(
                    header = LoadStateAdapter{adapter.retry()},
                    footer = LoadStateAdapter{adapter.retry()}
                )
                adapter.submitData(lifecycle,it)
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.progressState.collectLatest {
                binding.progressCircular.isVisible = it
            }
        }

        checkConnection(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter.setItemClickListener { navController.navigate(MainScreenDirections.actionMainScreenToDetailFragment(it)) }
        binding.editText.doAfterTextChanged { viewModel.onSearchTextChange(it.toString()) }
        adapter.addLoadStateListener { viewModel.onLoadStateChange(it) }
    }

    override fun onConnectionState(state: ConnectionState) {
        when (state) {
            ConnectionState.CONNECTED -> {
                adapter.retry()
            }
            ConnectionState.SLOW -> {
                adapter.retry()
            }
            else -> {
                Toast.makeText(requireContext(), "No internet", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
