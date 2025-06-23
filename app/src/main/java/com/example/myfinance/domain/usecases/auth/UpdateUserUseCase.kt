package com.example.myfinance.domain.usecases.auth

import com.example.myfinance.domain.model.auth.User
import com.example.myfinance.domain.repository.auth.AuthRepository
import javax.inject.Inject

class UpdateUserUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(user: User): Result<Unit> {
        return authRepository.updateUser(user)
    }
}