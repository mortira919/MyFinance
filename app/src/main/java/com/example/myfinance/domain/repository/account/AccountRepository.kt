package com.example.myfinance.domain.repository.account

import com.example.myfinance.domain.model.account.Account

interface AccountRepository {
    suspend fun getAllAccounts(): List<Account>
    suspend fun updateAccount(account: Account)
}