package com.example.myfinance.data.auth.mapper

import com.example.myfinance.data.auth.entity.UserEntity
import com.example.myfinance.domain.model.auth.User

class UserMapper {

    fun UserEntity.toDomain(): User = User(
        id = id,
        email = email,
        password = password,
        name = name
    )

    fun User.toEntity(): UserEntity = UserEntity(
        id = id,
        email = email,
        password = password,
        name = name
    )


}