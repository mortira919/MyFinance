package com.example.myfinance.data.transaction.repoimpl

import com.example.myfinance.data.dao.TransactionDao
import com.example.myfinance.data.transaction.mapper.TransactionMapper
import com.example.myfinance.domain.model.transaction.Transaction
import com.example.myfinance.domain.repository.transaction.TransactionRepository
import java.time.LocalDate
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    private val transactionMapper: TransactionMapper,
    private val dao: TransactionDao
) : TransactionRepository {

    override suspend fun getTransactions(userId: Int): List<Transaction> {
        return dao.getTransactions(userId).map { transactionMapper.toDomain(it) }
    }


    override suspend fun getTransactionsForPeriod(userId: Int, from: LocalDate, to: LocalDate): List<Transaction> =
        dao.getTransactionsForPeriod(userId, from, to).map { transactionMapper.toDomain(it) }

    override suspend fun getBalance(userId: Int): Long {
        val income = dao.getTotalIncome(userId) ?: 0
        val expense = dao.getTotalExpense(userId) ?: 0
        return income - expense
    }

    override suspend fun addTransaction(transaction: Transaction): Result<Unit> {
        dao.insertTransaction(transactionMapper.toEntity(transaction))
        return Result.success(Unit)
    }

    override suspend fun getTransactionsGroupedByDate(userId: Int): Map<LocalDate, List<Transaction>> {
        val entities = dao.getTransactions(userId)
        return entities
            .map { transactionMapper.toDomain(it) }
            .groupBy { it.date }
            .toSortedMap(compareByDescending { it }) // последние даты сверху
    }
    override suspend fun updateTransaction(transaction: Transaction) {
        dao.update(transactionMapper.toEntity(transaction))
    }
}