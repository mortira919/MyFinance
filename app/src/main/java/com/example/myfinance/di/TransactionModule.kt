package com.example.myfinance.di

import com.example.myfinance.data.db.AppDatabase
import com.example.myfinance.data.transaction.repoimpl.CategoryRepositoryImpl
import com.example.myfinance.data.transaction.repoimpl.TransactionRepositoryImpl
import com.example.myfinance.data.dao.CategoryDao
import com.example.myfinance.data.dao.TransactionDao
import com.example.myfinance.data.transaction.mapper.CategoryMapper
import com.example.myfinance.data.transaction.mapper.TransactionMapper
import com.example.myfinance.domain.repository.transaction.CategoryRepository
import com.example.myfinance.domain.repository.transaction.TransactionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object TransactionModule {

    // --- DAO ---
    @Provides
    fun provideTransactionDao(db: AppDatabase): TransactionDao = db.transactionDao()

    @Provides
    fun provideCategoryDao(db: AppDatabase): CategoryDao = db.categoryDao()

    @Provides
    fun provideTransactionMapper(): TransactionMapper = TransactionMapper()

    @Provides
    fun provideTransactionRepository(
        mapper: TransactionMapper,
        dao: TransactionDao
    ): TransactionRepository = TransactionRepositoryImpl(mapper, dao)


    @Provides
    fun provideCategoryRepository(
        dao: CategoryDao,
        mapper: CategoryMapper
    ): CategoryRepository = CategoryRepositoryImpl(dao, mapper)

    @Provides
    fun provideCategoryMapper(): CategoryMapper = CategoryMapper()
}