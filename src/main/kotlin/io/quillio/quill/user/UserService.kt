package io.quillio.quill.user

import io.quillio.quill.user.dto.request.RegisterUserRequest
import io.quillio.quill.user.dto.response.RegisterUserResponse
import io.quillio.quill.user.entity.UserEntity
import io.quillio.quill.user.repository.UserRepository
import org.springframework.context.ApplicationContext
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UserService(
    private val userRepository: UserRepository,
    private val context: ApplicationContext)
{
    fun registerUser(registerDto: RegisterUserRequest): Mono<RegisterUserResponse> {
        val encoder = context.getBean(PasswordEncoder::class.java)
        val hashed = encoder.encode(registerDto.password)
        return this.userRepository.save(registerDto.toEntityWithHash(hashed)).map{ user ->
            user.toResponse(user)
        }
    }
}