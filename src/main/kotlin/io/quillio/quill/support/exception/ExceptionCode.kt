package io.quillio.quill.support.exception

import org.springframework.http.HttpStatus

enum class ExceptionCode(val code: Int, val status: HttpStatus, val message: String) {
    INTERNAL_CUSTOM_ERROR(501, HttpStatus.INTERNAL_SERVER_ERROR, "내부 오류 테스트")
}