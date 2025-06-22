package com.example.myfinance.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {
    @GET("latest")
    suspend fun getRates(
        @Query("base") base: String
    ): RatesResponse
}