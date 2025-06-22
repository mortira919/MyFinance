package com.example.myfinance.data.currency.datasource

import com.example.myfinance.data.api.CurrencyApi
import javax.inject.Inject

class CurrencyRemoteDataSourceImpl @Inject constructor(
    private val api: CurrencyApi
) {
    suspend fun getRates(base: String): Map<String, Double> {
        return api.getRates(base).rates
    }
}
