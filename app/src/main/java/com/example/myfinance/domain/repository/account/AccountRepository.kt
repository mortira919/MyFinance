package com.example.myfinance.domain.repository.account

import com.example.myfinance.domain.model.account.Account
import com.example.myfinance.domain.model.currency.CurrencyType

interface AccountRepository {
    suspend fun getAllAccounts(): List<Account>
    suspend fun updateAccount(account: Account)
    suspend fun getUserCurrency(userId: Int): CurrencyType
    suspend fun setUserCurrency(userId: Int, currency: CurrencyType)

}