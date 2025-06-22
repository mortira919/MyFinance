package com.example.myfinance.data.transaction.mapper

import com.example.myfinance.domain.model.transaction.Transaction
import com.example.myfinance.domain.model.transaction.TransactionType
import com.example.myfinance.data.transaction.entity.TransactionEntity

class TransactionMapper {
    fun toDomain(entity: TransactionEntity): Transaction = Transaction(
        id = entity.id,
        userId = entity.userId,
        categoryId = entity.categoryId,
        amount = entity.amount,
        date = entity.date,
        type = TransactionType.valueOf(entity.type)
    )

    fun toEntity(domain: Transaction): TransactionEntity = TransactionEntity(
        id = domain.id,
        userId = domain.userId,
        categoryId = domain.categoryId,
        amount = domain.amount,
        date = domain.date,
        type = domain.type.name
    )
}