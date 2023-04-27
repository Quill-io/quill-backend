package io.quillio.quill.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/user"])
class UserController {
    @GetMapping(path = ["/authority/{test}"])
    fun getAuthority(@PathVariable test:String): String {
        return test
    }
}