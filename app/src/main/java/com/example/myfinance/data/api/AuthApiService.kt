package com.example.myfinance.data.api

import com.example.myfinance.data.UserDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("auth/google")
    suspend fun signInWithGoogle(@Body idToken: String): Response<UserDto>
}