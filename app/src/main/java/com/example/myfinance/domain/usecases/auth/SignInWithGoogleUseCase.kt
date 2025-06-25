package com.example.myfinance.domain.usecases.auth

import com.example.myfinance.domain.repository.auth.AuthRepository
import javax.inject.Inject

class SignInWithGoogleUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(idToken: String): Result<Unit> {
        return repository.signInWithGoogle(idToken)
    }
}