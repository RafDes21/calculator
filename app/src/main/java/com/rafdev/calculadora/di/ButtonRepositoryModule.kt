package com.rafdev.calculadora.di

import com.rafdev.calculadora.data.repository.ButtonRepositoryImpl
import com.rafdev.calculadora.domain.repository.ButtonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ButtonRepositoryModule {

    @Provides
    fun provideButtonRepository(): ButtonRepository {
        return ButtonRepositoryImpl()
    }
}