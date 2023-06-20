package com.librarian.elibrarian.controller

import com.librarian.elibrarian.model.Users
import com.librarian.elibrarian.service.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api")
class LoginController(@Autowired private val usersService: UsersService) {

    @PostMapping("/login")
    fun login(@RequestBody users: Users): ResponseEntity<String> {
        val user: Optional<Users> = usersService.getByUsername(users.username)

        return if(!user.isPresent) {
            ResponseEntity.status(HttpStatus.FORBIDDEN).body("no such user")
        } else {
            val userEntity: Users = user.get()
            if(userEntity.username == "administrator") {
                ResponseEntity.ok("redirect admin page")
            } else {
                ResponseEntity.ok("redirect librarian page")
            }
        }
    }

    @PostMapping("/logout")
    fun logout(): ResponseEntity<String> {
        return ResponseEntity.ok("logout")
    }
}