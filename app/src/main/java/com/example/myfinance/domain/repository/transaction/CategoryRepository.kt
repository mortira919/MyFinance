package com.example.myfinance.domain.repository.transaction

import com.example.myfinance.domain.model.transaction.Category
import com.example.myfinance.domain.model.transaction.TransactionType

interface CategoryRepository {
    suspend fun getCategoriesByType(type: TransactionType): List<Category>
    suspend fun addCategory(category: Category): Result<Unit>
    suspend fun getCategories(): List<Category>
    suspend fun updateCategory(category: Category): Result<Unit>
    suspend fun deleteCategory(categoryId: Int): Result<Unit>
}