package io.quillio.quill.user.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("user")
data class UserEntity(
    @Id
    val userId: Long,

    val email: String,

    val password: String,

    //카카오, 네이버, 구글, email
    val provider: String,

    //N, Y
    val deleteYn: String,

    @CreatedDate
    val createdAt: LocalDateTime,

    @LastModifiedDate
    val updatedAt: LocalDateTime
)