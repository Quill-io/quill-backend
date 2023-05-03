package io.quillio.quill.user.dto.response

import java.time.LocalDateTime

data class RegisterUserResponse(
    val id:Long,
    val email: String,
    val provider: String,
    val createdAt: LocalDateTime
)
