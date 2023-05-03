package io.quillio.quill.user.entity

import io.quillio.quill.user.dto.response.RegisterUserResponse
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("user")
data class UserEntity(
    @Id
    val userId: Long = 0L,

    val email: String,

    val password: String,

    //카카오, 네이버, 구글, email
    val provider: String = "email",

    //N, Y
    val deleteYn: String = "N",

    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @LastModifiedDate
    val updatedAt: LocalDateTime = LocalDateTime.now()
){
    fun toResponse(user: UserEntity): RegisterUserResponse {
        return RegisterUserResponse(
            id = user.userId,
            email = user.email,
            provider = user.provider,
            createdAt = user.createdAt
        )
    }
}