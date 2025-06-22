package com.example.myfinance.di

import com.example.myfinance.data.currency.datasource.CurrencyRemoteDataSourceImpl
import com.example.myfinance.data.currency.repoimpl.CurrencyRepositoryImpl
import com.example.myfinance.data.local.CurrencyPrefs
import com.example.myfinance.domain.repository.currency.CurrencyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CurrencyModule {

    @Provides
    @Singleton
    fun provideCurrencyRepository(
        remoteDataSource: CurrencyRemoteDataSourceImpl,
        currencyPrefs: CurrencyPrefs
    ): CurrencyRepository {
        return CurrencyRepositoryImpl(remoteDataSource, currencyPrefs)
    }
}