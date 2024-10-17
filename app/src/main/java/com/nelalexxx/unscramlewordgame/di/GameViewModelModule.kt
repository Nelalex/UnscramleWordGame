package com.nelalexxx.unscramlewordgame.di

import com.nelalexxx.unscramlewordgame.data.repositories.GameRepository
import com.nelalexxx.unscramlewordgame.data.repositories.GameRepositoryImpl

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object GameViewModelModule {
    @Provides
    fun provideMenuRepository(): GameRepository {
        return GameRepositoryImpl()
    }
}