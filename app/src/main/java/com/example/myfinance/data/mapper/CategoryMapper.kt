package com.example.myfinance.data.transaction.mapper

import com.example.myfinance.data.transaction.entity.CategoryEntity
import com.example.myfinance.domain.model.transaction.Category
import com.example.myfinance.domain.model.transaction.TransactionType


class CategoryMapper {
    fun mapToDomain(entity: CategoryEntity): Category = Category(
        id = entity.id,
        name = entity.name,
        icon = entity.icon,
        type = TransactionType.valueOf(entity.type)
    )

    fun toEntity(category: Category): CategoryEntity = CategoryEntity(
        id = category.id,
        name = category.name,
        icon = category.icon,
        type = category.type.name
    )
}