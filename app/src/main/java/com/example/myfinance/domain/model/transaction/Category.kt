package com.example.myfinance.domain.model.transaction

data class Category(
    val id: Int = 0,
    val name: String,
    val icon: String,
    val type: TransactionType
)