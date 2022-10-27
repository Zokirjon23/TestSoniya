package com.example.testsoniya.domain.repository.impl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.testsoniya.data.source.local.database.TestDataBase
import com.example.testsoniya.data.source.local.entity.BaseRelation
import com.example.testsoniya.data.source.remote.Api
import com.example.testsoniya.domain.repository.MainRepository
import com.example.testsoniya.utils.MainPagingSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val roomDatabase: TestDataBase,
    private val api: Api
) : MainRepository {

   override fun getAllCharacter() =
        Pager(config = PagingConfig(pageSize = 10), pagingSourceFactory = {
            MainPagingSource(api,roomDatabase)
        }).flow.flowOn(Dispatchers.IO)

    override fun searchCharacter(name : String)=
        Pager(config = PagingConfig(pageSize = 10), pagingSourceFactory = {
            MainPagingSource(api,roomDatabase,name)
        }).flow.flowOn(Dispatchers.IO)

    override fun getSavedData() = flow<BaseRelation>{
    }
}