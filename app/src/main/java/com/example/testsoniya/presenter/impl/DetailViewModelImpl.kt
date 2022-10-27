package com.example.testsoniya.presenter.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testsoniya.data.model.Result
import com.example.testsoniya.domain.usescase.DetailUsesCase
import com.example.testsoniya.presenter.DetailViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModelImpl @Inject constructor(private val usesCase: DetailUsesCase) : DetailViewModel,ViewModel() {
    override val initUi = MutableStateFlow(Unit)
}