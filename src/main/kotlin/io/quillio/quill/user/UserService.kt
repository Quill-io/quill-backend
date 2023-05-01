package io.quillio.quill.user

import io.quillio.quill.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

}