package io.quillio.quill.support.exception

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class AppExceptionHandler {
    val log: Logger = LogManager.getLogger()

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(AppException::class)
    fun appExceptionHandle(e: AppException): String {
        log.error("appException: {}", e.toString())

        return e.toString()
    }
}