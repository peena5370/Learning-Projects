package com.librarian.elibrarian.service

import com.librarian.elibrarian.model.Users
import java.util.*

interface UsersService {
    fun create(users: Users): Users
    fun getAll(): List<Users>
    fun getById(uId: Int): Optional<Users>
    fun getByUsername(username: String): Optional<Users>
    fun update(users: Users): Users
    fun remove(uId: Int): Int
}