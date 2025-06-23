package com.example.myfinance.domain.model.auth

data class User(
    val id: Int = 0,
    val email: String,
    val password: String,
    val name: String
)