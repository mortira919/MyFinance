package com.example.myfinance.domain.usecases.currency

import com.example.myfinance.domain.repository.currency.CurrencyRepository
import javax.inject.Inject

class GetCurrencyRatesUseCase @Inject constructor(
    private val repository: CurrencyRepository
) {
    suspend operator fun invoke(base: String): Map<String, Double> {
        return repository.getRates(base)
    }
}