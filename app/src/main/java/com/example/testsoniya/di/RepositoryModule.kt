package com.example.testsoniya.di

import com.example.testsoniya.domain.repository.MainRepository
import com.example.testsoniya.domain.repository.impl.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindMainRepository(mainRepositoryImpl: MainRepositoryImpl) : MainRepository
}