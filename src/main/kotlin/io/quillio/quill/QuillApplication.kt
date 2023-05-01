package io.quillio.quill

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@EnableWebFlux
/* db 구성 전까지 DataSourceAutoConfiguration, R2dbcAutoConfiguration 제외 */
@SpringBootApplication
class QuillApplication

fun main(args: Array<String>) {
	runApplication<QuillApplication>(*args)
}
