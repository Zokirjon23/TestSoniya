package com.example.testsoniya.presenter

import androidx.paging.CombinedLoadStates
import androidx.paging.PagingData
import kotlinx.coroutines.flow.StateFlow
import com.example.testsoniya.data.model.Character
import com.example.testsoniya.data.model.Result
import com.muddassir.connection_checker.ConnectionState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

interface MainScreenViewModel {
    fun onSearchTextChange(query: String)
    fun onLoadStateChange(state: CombinedLoadStates)

    val progressState : StateFlow<Boolean>
    val data : MutableSharedFlow<PagingData<Result>>
    val error: SharedFlow<String>
}