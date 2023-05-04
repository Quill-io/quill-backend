package io.quillio.quill.user.repository

import io.quillio.quill.user.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.r2dbc.core.flow
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class UserRepository2(private val r2dbcEntityTemplate: R2dbcEntityTemplate) {
    fun readUser(id: Long) : Flow<UserEntity> {
        val query = r2dbcEntityTemplate.databaseClient.sql(
            """
                SELECT *
                FROM user
                WHERE userId = :id
            """.trimIndent()
        ).bind("id", id)

        return query.map{res ->
            UserEntity(
                res.get(0) as Long,
                res.get(1) as String,
                res.get(2) as String,
                res.get(3) as String,
                res.get(4) as String,
                res.get(5) as LocalDateTime,
                res.get(6) as LocalDateTime
            )
        }.flow()
    }
}