package io.quillio.quill.support.config

import io.r2dbc.pool.ConnectionPool
import io.r2dbc.pool.ConnectionPoolConfiguration
import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing

@Configuration
@ConfigurationProperties(prefix = "datasource")
@EnableR2dbcAuditing
class DataSourceConfig : AbstractR2dbcConfiguration() {
    lateinit var config : DataSourceProperties

    @Bean
    override fun connectionFactory(): ConnectionFactory {
        val option = ConnectionFactoryOptions.parse(config.url)
        return ConnectionFactories.get(
            ConnectionFactoryOptions.builder()
                .from(option)
                .option(ConnectionFactoryOptions.USER, config.username)
                .option(ConnectionFactoryOptions.PASSWORD, config.password)
                .build()
        )
    }

    @Bean
    fun connectionPoolConfiguration(connectionFactory: ConnectionFactory) : ConnectionPool {
        val configuration = ConnectionPoolConfiguration.builder(connectionFactory)
            .initialSize(1)
            .maxSize(config.maxSize)
            .acquireRetry(3)
            .maxLifeTime(config.maxLifetime)
            .maxIdleTime(config.maxIdletime)
            .maxValidationTime(config.validationTimeout)
            .maxCreateConnectionTime(config.connectTimeout)
            .build()

        return ConnectionPool(configuration)
    }
}
