package com.example.myfinance.di

import android.content.Context
import androidx.datastore.core.DataStore
import com.example.myfinance.data.api.CurrencyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import com.example.myfinance.data.local.dataStore
import retrofit2.converter.gson.GsonConverterFactory
import androidx.datastore.preferences.core.Preferences


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideCurrencyApi(): CurrencyApi {
        return Retrofit.Builder()
            .baseUrl("https://api.exchangerate.host/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurrencyApi::class.java)
    }
    @Provides
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> =
        context.dataStore



}