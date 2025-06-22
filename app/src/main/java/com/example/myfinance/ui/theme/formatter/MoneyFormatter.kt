package com.example.myfinance.ui.theme.formatter

import com.example.myfinance.domain.model.transaction.TransactionType

object MoneyFormatter {
    fun format(amount: Long, type: TransactionType): String {
        val formatted = "%,d".format(amount).replace(",", " ")
        val sign = if (type == TransactionType.INCOME) "+" else "-"
        return "$sign$formatted KZT"
    }
}