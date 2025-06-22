package com.example.myfinance.domain.usecases.auth

import com.example.myfinance.domain.repository.auth.AuthRepository
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(
    private val repo: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String) = repo.login(email, password)
}