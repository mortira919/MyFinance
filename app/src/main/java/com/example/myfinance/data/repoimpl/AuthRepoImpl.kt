package com.example.myfinance.data.auth.repoimpl

import com.example.myfinance.domain.repository.auth.AuthRepository
import com.example.myfinance.domain.model.auth.User
import com.example.myfinance.data.auth.entity.UserEntity
import com.example.myfinance.data.dao.AuthDao
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val dao: AuthDao,
    private val api: AuthApiService,
    private val localDataSource: UserLocalDataSource
) : AuthRepository {

    override suspend fun register(user: User): Result<Unit> {
        val existing = dao.getUserByEmail(user.email)
        return if (existing != null) {
            Result.failure(Exception("User already exists"))
        } else {
            dao.insertUser(user.toEntity())
            Result.success(Unit)
        }
    }

    override suspend fun login(email: String, password: String): Result<User> {
        val user = dao.getUserByEmail(email)
        return if (user != null && user.password == password) {
            Result.success(user.toDomain())
        } else {
            Result.failure(Exception("Invalid credentials"))
        }
    }
    override suspend fun getCurrentUserId(): Int {
        return dao.getUser()?.id ?: error("Пользователь не найден")
    }

    private fun User.toEntity() = UserEntity(id, email, password,name)
    private fun UserEntity.toDomain() = User(id, email, password, name)

    override suspend fun updateUser(user: User): Result<Unit> {
        return try {
            dao.updateUser(user.toEntity())
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    override suspend fun logout() {
        dao.clearUsers()
    }

    override suspend fun signInWithGoogle(idToken: String): Result<Unit> {
        return try {
            val response = api.signInWithGoogle(idToken) // Можешь заменить на мок/локальную логику
            if (response.isSuccessful && response.body() != null) {
                val userDto = response.body()!!
                localDataSource.saveUser(userDto.toEntity()) // Сохраняем в Room/DataStore
                Result.success(Unit)
            } else {
                Result.failure(Exception("Google Sign-In failed: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}