package com.example.myfinance.domain.model.account

data class Account(
    val id: Int,
    val userId: Int,
    val name: String,
    val amount: Double,
    val currencyCode: String
)