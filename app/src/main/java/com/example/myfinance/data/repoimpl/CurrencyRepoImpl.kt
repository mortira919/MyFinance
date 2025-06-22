package com.example.myfinance.data.currency.repoimpl


import com.example.myfinance.data.api.CurrencyApi
import com.example.myfinance.data.currency.datasource.CurrencyRemoteDataSourceImpl
import com.example.myfinance.data.local.CurrencyPrefs
import com.example.myfinance.domain.repository.currency.CurrencyRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow


class CurrencyRepositoryImpl @Inject constructor(
    private val remote: CurrencyRemoteDataSourceImpl,
    private val prefs: CurrencyPrefs
) : CurrencyRepository {

    override suspend fun saveCurrency(code: String) {
        prefs.saveCurrency(code)
    }

    override fun getSelectedCurrency(): Flow<String> {
        return prefs.selectedCurrency
    }

    override suspend fun getRates(base: String): Map<String, Double> {
        return remote.getRates(base)
    }
}
