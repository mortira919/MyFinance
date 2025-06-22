package com.example.myfinance.domain.usecases.transaction

import com.example.myfinance.domain.repository.transaction.TransactionRepository
import javax.inject.Inject

class GetBalanceUseCase @Inject constructor(
    private val repository: TransactionRepository
) {
    suspend operator fun invoke(userId: Int) = repository.getBalance(userId)
}