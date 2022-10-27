package com.example.testsoniya.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testsoniya.data.source.local.database.TestDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @[Singleton Provides]
    fun provideRoom(@ApplicationContext context: Context) : TestDataBase {
        return Room.databaseBuilder(context, TestDataBase::class.java, "database.db")
            .build()
    }



}