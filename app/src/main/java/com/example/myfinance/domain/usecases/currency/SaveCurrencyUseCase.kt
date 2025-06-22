package com.example.myfinance.domain.usecases.currency

import com.example.myfinance.domain.repository.currency.CurrencyRepository
import javax.inject.Inject

class SaveCurrencyUseCase @Inject constructor(
    private val repository: CurrencyRepository
) {
    suspend operator fun invoke(code: String) = repository.saveCurrency(code)
}