package com.example.myfinance.domain.repository.transaction

import com.example.myfinance.domain.model.transaction.Transaction
import java.time.LocalDate

interface TransactionRepository {
    suspend fun getTransactions(userId: Int): List<Transaction>
    suspend fun getTransactionsForPeriod(userId: Int, from: LocalDate, to: LocalDate):
            List<Transaction>
    suspend fun getBalance(userId: Int): Long
    suspend fun addTransaction(transaction: Transaction): Result<Unit>
    suspend fun getTransactionsGroupedByDate(userId: Int): Map<LocalDate, List<Transaction>>
    suspend fun updateTransaction(transaction: Transaction)
}