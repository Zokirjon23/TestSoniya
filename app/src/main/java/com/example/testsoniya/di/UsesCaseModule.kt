package com.example.testsoniya.di

import com.example.testsoniya.domain.usescase.DetailUsesCase
import com.example.testsoniya.domain.usescase.MainUsesCase
import com.example.testsoniya.domain.usescase.impl.DetailUsesCaseImpl
import com.example.testsoniya.domain.usescase.impl.MainUsesCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UsesCaseModule {

    @Binds
    fun bindMainViewModel(mainUsesCase: MainUsesCaseImpl) : MainUsesCase

    @Binds
    fun bindDetailViewModel(detailUsesCaseImpl: DetailUsesCaseImpl) : DetailUsesCase

}