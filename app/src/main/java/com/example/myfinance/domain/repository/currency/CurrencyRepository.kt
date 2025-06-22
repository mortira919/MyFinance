package com.example.myfinance.domain.repository.currency

import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {
    suspend fun saveCurrency(code: String)
    fun getSelectedCurrency(): Flow<String>
    suspend fun getRates(base: String): Map<String, Double>
}
