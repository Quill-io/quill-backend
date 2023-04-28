package io.quillio.quill.support.exception

class AppException : RuntimeException {
    private val code : Int

    constructor(message: String, code: Int) : super(message) {
        this.code = code
    }

    constructor(exceptionCode: ExceptionCode) : super(exceptionCode.message) {
        this.code = exceptionCode.code
    }
}