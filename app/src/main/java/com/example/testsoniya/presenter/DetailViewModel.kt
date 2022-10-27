package com.example.testsoniya.presenter

import kotlinx.coroutines.flow.StateFlow

interface DetailViewModel {
    val initUi : StateFlow<Unit>

}