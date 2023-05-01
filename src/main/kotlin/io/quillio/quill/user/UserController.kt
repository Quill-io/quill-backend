package io.quillio.quill.user

import io.quillio.quill.support.exception.AppException
import io.quillio.quill.support.exception.ExceptionCode
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/user"])
class UserController(private val userService: UserService) {
    @GetMapping(path = ["/authority/{test}"])
    fun getAuthority(@PathVariable test:String): String {
        if (test.equals("1")) {
            throw AppException(ExceptionCode.INTERNAL_CUSTOM_ERROR)
        }

        return test
    }
}