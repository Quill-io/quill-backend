package io.quillio.quill.user.repository

import io.quillio.quill.user.entity.UserEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface UserRepository : ReactiveCrudRepository<UserEntity, Long>{
}