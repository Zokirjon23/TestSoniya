package com.example.testsoniya.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.testsoniya.data.source.local.converter.ResultTypeConverter
import com.example.testsoniya.data.source.local.dao.ResultDao
import com.example.testsoniya.data.source.local.entity.*
import com.example.testsoniya.data.source.local.entity.Result

@Database(entities = [Result::class], version = 1)
@TypeConverters(ResultTypeConverter::class)
abstract class TestDataBase : RoomDatabase(){

    abstract fun resultDao() : ResultDao
}

