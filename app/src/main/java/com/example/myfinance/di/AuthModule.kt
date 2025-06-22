package com.example.myfinance.di

import com.example.myfinance.data.dao.AuthDao
import com.example.myfinance.data.auth.repoimpl.AuthRepositoryImpl
import com.example.myfinance.data.db.AppDatabase
import com.example.myfinance.domain.repository.auth.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Provides
    fun provideAuthDao(db: AppDatabase): AuthDao = db.authDao()

    @Provides
    fun provideAuthRepo(dao: AuthDao): AuthRepository = AuthRepositoryImpl(dao)


}