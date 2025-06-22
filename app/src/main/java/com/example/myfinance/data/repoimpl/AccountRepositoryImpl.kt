package com.example.myfinance.data.repoimpl

import com.example.myfinance.data.dao.AccountDao
import com.example.myfinance.data.mapper.toDomain
import com.example.myfinance.data.mapper.toEntity
import com.example.myfinance.domain.model.account.Account
import com.example.myfinance.domain.repository.account.AccountRepository
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val dao: AccountDao
) : AccountRepository {
    override suspend fun getAllAccounts(): List<Account> {
        return dao.getAll().map { it.toDomain() }
    }

    override suspend fun updateAccount(account: Account) {
        dao.updateAccount(account.toEntity())
    }
}