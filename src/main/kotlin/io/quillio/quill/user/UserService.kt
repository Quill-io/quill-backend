package io.quillio.quill.user

import io.quillio.quill.user.entity.UserEntity
import io.quillio.quill.user.repository.UserRepository
import org.springframework.stereotype.Service
import kotlinx.coroutines.flow.Flow

@Service
class UserService(
    private val userRepository: UserRepository
) {

    suspend fun getUser(id: Long) : Flow<UserEntity> {
        return userRepository.readUser(id)
    }
}