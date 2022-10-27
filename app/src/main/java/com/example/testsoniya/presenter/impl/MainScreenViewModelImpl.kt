package com.example.testsoniya.presenter.impl

import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.map
import com.example.testsoniya.data.model.Character
import com.example.testsoniya.domain.usescase.MainUsesCase
import com.example.testsoniya.presenter.MainScreenViewModel
import com.muddassir.connection_checker.ConnectionState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModelImpl @Inject constructor(private val usesCase: MainUsesCase) :
    MainScreenViewModel, ViewModel() {
    override val progressState = MutableStateFlow(true)
    override val data = MutableSharedFlow<PagingData<com.example.testsoniya.data.model.Result>>()
    override val error = MutableSharedFlow<String>()

//    override val resultPager = usesCase.getCharacters()

    init {
        usesCase.getCharacters().onEach {
            data.emit(it)
        }.launchIn(viewModelScope)
    }

    override fun onSearchTextChange(query: String) {
        usesCase.findCharacter(query).onEach {
            data.emit(it)
        }.launchIn(viewModelScope)
    }

    override fun onLoadStateChange(state: CombinedLoadStates) {
        viewModelScope.launch {
            when (val currentState = state.refresh) {
                is LoadState.Loading -> {
                    progressState.value = true
                }
                is LoadState.Error -> {
                    val extractedException = currentState.error
                    error.emit(extractedException.message.toString())
                }
                is LoadState.NotLoading -> progressState.value = false
            }
        }
    }
}