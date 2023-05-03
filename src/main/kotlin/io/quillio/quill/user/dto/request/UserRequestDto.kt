package io.quillio.quill.user.dto.request

import io.quillio.quill.user.entity.UserEntity

data class RegisterUserRequest(
    val email: String,
    val password: String,
) {
    fun toEntity(): UserEntity{
        return UserEntity(
            email = email,
            password = password
        )
    }

    fun toEntityWithHash(hashed: String): UserEntity {
        return UserEntity(
            email = email,
            password = hashed
        )
    }

}
