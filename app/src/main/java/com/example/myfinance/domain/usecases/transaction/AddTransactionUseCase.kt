package com.example.myfinance.domain.usecases.transaction

import com.example.myfinance.domain.model.transaction.Transaction
import com.example.myfinance.domain.repository.transaction.TransactionRepository
import javax.inject.Inject

class AddTransactionUseCase @Inject constructor(
    private val repository: TransactionRepository
) {
    suspend operator fun invoke(transaction: Transaction) = repository.addTransaction(transaction)
}