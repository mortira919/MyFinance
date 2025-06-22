package com.example.myfinance.data.dao

import androidx.room.*
import com.example.myfinance.data.entity.AccountEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDao {

    @Query("SELECT * FROM accounts")
    suspend fun getAll(): List<AccountEntity>

    @Update
    suspend fun updateAccount(account: AccountEntity)
}