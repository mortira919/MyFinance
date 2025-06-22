package com.example.myfinance.data.auth.mapper

import com.example.myfinance.data.auth.entity.UserEntity
import com.example.myfinance.domain.model.auth.User

class UserMapper {
    // data/mapper/UserMapper.kt
    fun UserEntity.toDomain(): User = User(
        id = id,
        email = email,
        password = password
    )

    fun User.toEntity(): UserEntity = UserEntity(
        id = id,
        email = email,
        password = password
    )

}