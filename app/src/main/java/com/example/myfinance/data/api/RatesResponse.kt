package com.example.myfinance.data.api

data class RatesResponse(
    val base: String,
    val rates: Map<String, Double>,
    val date: String
)