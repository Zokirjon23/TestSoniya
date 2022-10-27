package com.example.testsoniya.utils

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.testsoniya.data.model.*
import com.example.testsoniya.data.source.local.database.TestDataBase
import com.example.testsoniya.data.source.local.entity.toModel
import com.example.testsoniya.data.source.remote.Api
import kotlinx.coroutines.delay
import xyz.teamgravity.checkinternet.CheckInternet

class MainPagingSource(
    private val api: Api,
    private val testDataBase: TestDataBase,
    private val querySearch: String? = null
) : PagingSource<Int, Result>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val nextPageNumber = params.key ?: 0

            if (CheckInternet().check()) {
                val response = if (querySearch.isNullOrEmpty()) api.allArtist(nextPageNumber)
                else api.searchCharacter(nextPageNumber, querySearch)
                testDataBase.resultDao().insertAll(response.body()!!.results.map { it.toModel() })

                LoadResult.Page(
                    data = response.body()!!.results,
                    prevKey = if (nextPageNumber > 0) nextPageNumber - 1 else null,
                    nextKey = if (nextPageNumber < response.body()!!.info.pages) nextPageNumber + 1 else null
                )
            } else {
                val entity = if (querySearch.isNullOrEmpty()) testDataBase.resultDao()
                    .getResults(params.loadSize, nextPageNumber * params.loadSize)
                else testDataBase.resultDao().getResultsByName(
                    params.loadSize,
                    nextPageNumber * params.loadSize,
                    querySearch
                )
                if (nextPageNumber != 0) delay(1000)

                LoadResult.Page(
                    data = entity.map { it.toModel() },
                    prevKey = if (nextPageNumber == 0) null else nextPageNumber - 1,
                    nextKey = if (entity.isEmpty()) null else nextPageNumber + 1
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}