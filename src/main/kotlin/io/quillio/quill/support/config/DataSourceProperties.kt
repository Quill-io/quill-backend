package io.quillio.quill.support.config

import org.springframework.boot.context.properties.ConstructorBinding
import java.time.Duration

@ConstructorBinding
data class DataSourceProperties(
    val url: String,
    val username: String,
    val password: String,
    val maxSize: Int,
    val maxLifetime: Duration,
    val maxIdletime: Duration,
    val validationTimeout: Duration,
    val connectTimeout: Duration
)
