package com.example.myfinance.di

import com.example.myfinance.data.dao.AccountDao
import com.example.myfinance.data.db.AppDatabase
import com.example.myfinance.data.repoimpl.AccountRepositoryImpl
import com.example.myfinance.domain.repository.account.AccountRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AccountModule {

    @Provides
    @Singleton
    fun provideAccountRepository(dao: AccountDao): AccountRepository =
        AccountRepositoryImpl(dao)

    @Provides
    @Singleton
    fun provideAccountDao(db: AppDatabase): AccountDao = db.accountDao()
}