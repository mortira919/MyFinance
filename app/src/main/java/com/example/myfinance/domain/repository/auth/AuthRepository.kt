package com.example.myfinance.domain.repository.auth

import com.example.myfinance.domain.model.auth.User

interface AuthRepository {
    suspend fun register(user: User): Result<Unit>
    suspend fun login(email: String, password: String): Result<User>
    suspend fun getCurrentUserId(): Int
    suspend fun updateUser(user: User): Result<Unit>
    suspend fun logout()
}
