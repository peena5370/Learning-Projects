package com.librarian.elibrarian.controller

import com.librarian.elibrarian.model.Users
import com.librarian.elibrarian.service.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/users")
class UserController(@Autowired private val usersService: UsersService) {

    @PostMapping
    fun register(@RequestBody users: Users): ResponseEntity<Users> {
        return ResponseEntity.ok(usersService.create(users))
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<Users>> {
        return ResponseEntity.ok(usersService.getAll())
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): ResponseEntity<Optional<Users>> {
        return ResponseEntity.ok(usersService.getById(id))
    }

    @PutMapping("/{id}")
    fun update(@RequestBody users: Users): ResponseEntity<Users> {
        return ResponseEntity.ok(usersService.update(users))
    }

    @DeleteMapping("/{id}")
    fun remove(@PathVariable id: Int): ResponseEntity<Int> {
        return ResponseEntity.ok(usersService.remove(id))
    }
}