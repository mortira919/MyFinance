package com.example.myfinance.domain.usecases.auth

import com.example.myfinance.domain.model.auth.User
import com.example.myfinance.domain.repository.auth.AuthRepository
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val repo: AuthRepository
) {
    suspend operator fun invoke(user: User) = repo.register(user)
}