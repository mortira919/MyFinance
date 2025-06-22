package com.example.myfinance.data.transaction.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: Int,
    val categoryId: Int,
    val amount: Double,
    val date: LocalDate,
    val type: String // INCOME или EXPENSE
)
