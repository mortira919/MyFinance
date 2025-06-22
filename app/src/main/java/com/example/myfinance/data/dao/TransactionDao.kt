package com.example.myfinance.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myfinance.data.transaction.entity.TransactionEntity
import java.time.LocalDate

@Dao
interface TransactionDao {

    @Query("SELECT * FROM transactions WHERE userId = :userId ORDER BY date DESC")
    suspend fun getTransactions(userId: Int): List<TransactionEntity>

    @Query("SELECT * FROM transactions WHERE userId = :userId AND date BETWEEN :start AND :end")
    suspend fun getTransactionsForPeriod(userId: Int, start: LocalDate, end: LocalDate): List<TransactionEntity>

    @Query("SELECT SUM(amount) FROM transactions WHERE userId = :userId AND type = 'INCOME'")
    suspend fun getTotalIncome(userId: Int): Long?

    @Query("SELECT SUM(amount) FROM transactions WHERE userId = :userId AND type = 'EXPENSE'")
    suspend fun getTotalExpense(userId: Int): Long?

    @Insert
    suspend fun insertTransaction(transaction: TransactionEntity)

    @Update
    suspend fun update(transaction: TransactionEntity)






}