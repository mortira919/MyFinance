package com.example.myfinance.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myfinance.data.auth.entity.UserEntity
import com.example.myfinance.data.dao.AuthDao
import com.example.myfinance.data.dao.AccountDao
import com.example.myfinance.data.db.converter.DateConverter
import com.example.myfinance.data.dao.CategoryDao
import com.example.myfinance.data.dao.TransactionDao
import com.example.myfinance.data.transaction.entity.CategoryEntity
import com.example.myfinance.data.transaction.entity.TransactionEntity
import com.example.myfinance.data.entity.AccountEntity

@Database(
    entities = [UserEntity::class,AccountEntity::class, TransactionEntity::class, CategoryEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun authDao(): AuthDao
    abstract fun transactionDao(): TransactionDao
    abstract fun categoryDao(): CategoryDao
    abstract fun accountDao(): AccountDao
}