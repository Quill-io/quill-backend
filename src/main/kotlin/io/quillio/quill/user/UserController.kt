package io.quillio.quill.user

import io.quillio.quill.user.dto.request.RegisterUserRequest
import io.quillio.quill.user.dto.response.RegisterUserResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping(path = ["/user"])
class UserController(private val userService: UserService) {
    @PostMapping(path = ["/signup"])
    fun registerUser(registerDto: RegisterUserRequest): Mono<RegisterUserResponse> {
        return this.userService.registerUser(registerDto)
    }
}