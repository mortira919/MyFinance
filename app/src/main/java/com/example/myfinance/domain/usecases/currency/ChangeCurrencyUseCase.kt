package com.example.myfinance.domain.usecases.currency

import com.example.myfinance.domain.model.currency.CurrencyType
import com.example.myfinance.domain.repository.account.AccountRepository
import com.example.myfinance.domain.repository.auth.AuthRepository
import com.example.myfinance.domain.repository.currency.CurrencyRepository
import com.example.myfinance.domain.repository.transaction.TransactionRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class ChangeCurrencyUseCase @Inject constructor(
    private val currencyRepository: CurrencyRepository,
    private val transactionRepository: TransactionRepository,
    private val accountRepository: AccountRepository,
    private val authRepository: AuthRepository
) {
    suspend fun execute(newCurrency: CurrencyType) {
        // Получаем текущую валюту
        val oldCurrency = currencyRepository.getSelectedCurrency().first()
        if (oldCurrency == newCurrency.code) return

        // Получаем актуальные курсы
        val rates = currencyRepository.getRates(oldCurrency)
        val rate = rates[newCurrency.code] ?: error("Нет курса для ${newCurrency.code}")

        // Получаем userId
        val userId = authRepository.getCurrentUserId()

        // Пересчёт всех аккаунтов
        val accounts = accountRepository.getAllAccounts().filter { it.userId == userId }
        accounts.forEach {
            val convertedAmount = it.amount * rate
            accountRepository.updateAccount(it.copy(amount = convertedAmount))
        }

        // Пересчёт всех транзакций
        val transactions = transactionRepository.getTransactions(userId)
        transactions.forEach {
            val convertedAmount = it.amount * rate
            transactionRepository.updateTransaction(it.copy(amount = convertedAmount))
        }

        // Сохраняем выбранную валюту
        currencyRepository.saveCurrency(newCurrency.code)
        // Обновляем валюту пользователя в аккаунтах
        accountRepository.setUserCurrency(userId, newCurrency)
    }
}
