package com.example.myfinance.domain.usecases.transaction

import com.example.myfinance.domain.model.transaction.Category
import com.example.myfinance.domain.model.transaction.Transaction
import com.example.myfinance.domain.repository.transaction.CategoryRepository
import com.example.myfinance.domain.repository.transaction.TransactionRepository
import java.time.LocalDate

class GetGroupedTransactionsUseCase(
    private val transactionRepository: TransactionRepository,
    private val categoryRepository: CategoryRepository
) {
    suspend operator fun invoke(userId: Int): Map<LocalDate, List<Pair<Transaction, Category>>> {
        val transactions = transactionRepository.getTransactions(userId)
        val categories = categoryRepository.getCategories()

        val categoryMap = categories.associateBy { it.id }

        return transactions
            .mapNotNull { tx ->
                val cat = categoryMap[tx.categoryId] ?: return@mapNotNull null
                tx to cat
            }
            .groupBy { it.first.date }
            .toSortedMap(compareByDescending { it })
    }
}