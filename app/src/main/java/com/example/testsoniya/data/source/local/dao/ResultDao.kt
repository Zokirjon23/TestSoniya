package com.example.testsoniya.data.source.local.dao

import androidx.room.*

@Dao
interface ResultDao {

    @Query("SELECT * FROM Result ORDER BY id ASC LIMIT  :limit OFFSET :offset")
    suspend fun getResults(limit : Int,offset : Int) : List<com.example.testsoniya.data.source.local.entity.Result>

    @Query("SELECT * FROM Result WHERE name LIKE :name || '%' ORDER BY id ASC LIMIT  :limit OFFSET :offset")
    suspend fun getResultsByName(limit : Int,offset : Int,name : String) : List<com.example.testsoniya.data.source.local.entity.Result>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list : List<com.example.testsoniya.data.source.local.entity.Result>)
}