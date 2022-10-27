package com.example.testsoniya.domain.usescase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface MainUsesCase {
    fun getCharacters() : Flow<PagingData<com.example.testsoniya.data.model.Result>>
    fun findCharacter(name : String) : Flow<PagingData<com.example.testsoniya.data.model.Result>>
}