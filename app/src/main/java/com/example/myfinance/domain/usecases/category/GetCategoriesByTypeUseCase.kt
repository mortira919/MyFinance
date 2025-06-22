package com.example.myfinance.domain.usecases.category

import com.example.myfinance.domain.model.transaction.TransactionType
import com.example.myfinance.domain.repository.transaction.CategoryRepository
import javax.inject.Inject

class GetCategoriesByTypeUseCase @Inject constructor(
    private val repository: CategoryRepository
) {
    suspend operator fun invoke(type: TransactionType) = repository.getCategoriesByType(type)
}