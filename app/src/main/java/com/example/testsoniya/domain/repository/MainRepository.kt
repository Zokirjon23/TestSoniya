package com.example.testsoniya.domain.repository

import androidx.paging.PagingData
import com.example.testsoniya.data.model.Result
import com.example.testsoniya.data.source.local.entity.BaseRelation
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun getAllCharacter(): Flow<PagingData<Result>>
    fun searchCharacter(name : String): Flow<PagingData<Result>>

    fun getSavedData(): Flow<BaseRelation>
}