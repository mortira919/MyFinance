package com.example.myfinance.data.mapper


import com.example.myfinance.data.entity.AccountEntity
import com.example.myfinance.domain.model.account.Account





fun AccountEntity.toDomain(): Account = Account(id, userId, name, amount, currencyCode)

fun Account.toEntity(): AccountEntity = AccountEntity(id, userId, name, amount, currencyCode)

