package com.example.myfinance.domain.model.transaction

import java.time.LocalDate

data class Transaction(
    val id: Int = 0,
    val userId: Int,
    val categoryId: Int,
    val amount: Double,
    val date: LocalDate,
    val type: TransactionType // INCOME / EXPENSE
)

enum class TransactionType { INCOME, EXPENSE }