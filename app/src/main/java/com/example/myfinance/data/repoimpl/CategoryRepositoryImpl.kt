package com.example.myfinance.data.transaction.repoimpl

import com.example.myfinance.data.dao.CategoryDao
import com.example.myfinance.data.transaction.mapper.CategoryMapper
import com.example.myfinance.domain.model.transaction.Category
import com.example.myfinance.domain.model.transaction.TransactionType
import com.example.myfinance.domain.repository.transaction.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val dao: CategoryDao,
    private val mapper: CategoryMapper
) : CategoryRepository {

    override suspend fun getCategoriesByType(type: TransactionType): List<Category> {
        return dao.getCategoriesByType(type.name).map { mapper.mapToDomain(it) }
    }

    override suspend fun addCategory(category: Category): Result<Unit> {
        dao.insertCategory(mapper.toEntity(category))
        return Result.success(Unit)
    }
    override suspend fun getCategories(): List<Category> {
        return dao.getAllCategories().map { mapper.mapToDomain(it) }
    }
    override suspend fun updateCategory(category: Category): Result<Unit> {
        dao.updateCategory(mapper.toEntity(category))
        return Result.success(Unit)
    }

    override suspend fun deleteCategory(categoryId: Int): Result<Unit> {
        dao.deleteCategory(categoryId)
        return Result.success(Unit)
    }
}