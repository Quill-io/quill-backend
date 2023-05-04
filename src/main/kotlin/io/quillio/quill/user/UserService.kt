package io.quillio.quill.user

import io.quillio.quill.user.entity.UserEntity
import io.quillio.quill.user.repository.UserRepository
import io.quillio.quill.user.repository.UserRepository2
import org.springframework.stereotype.Service
import kotlinx.coroutines.flow.Flow

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userRepository2: UserRepository2
) {

    suspend fun getUser(id: Long) : Flow<UserEntity> {
        return userRepository2.readUser(id)
    }
}