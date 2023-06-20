package com.librarian.elibrarian.service.impl

import com.librarian.elibrarian.model.Users
import com.librarian.elibrarian.repos.UserRepository
import com.librarian.elibrarian.service.UsersService
import com.librarian.elibrarian.utils.PasswordEncryption
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class UsersServiceImpl(@Autowired private val userRepository: UserRepository): UsersService {
    override fun create(users: Users): Users {
        val salt: String = PasswordEncryption().getSaltValue(32)
        val hashedPassword: String = PasswordEncryption().generateSecurePassword(users.password, salt)
        users.password = hashedPassword
        users.secretKey = salt
        users.createTime = LocalDateTime.now()

        return userRepository.saveAndFlush(users)
    }

    override fun getAll(): List<Users> {
        return userRepository.findAll()
    }

    override fun getById(uId: Int): Optional<Users> {
        return userRepository.findById(uId)
    }

    override fun getByUsername(username: String): Optional<Users> {
        return userRepository.findByUsername(username)
    }

    override fun update(users: Users): Users {
        val salt: String = PasswordEncryption().getSaltValue(32)
        val hashedPassword: String = PasswordEncryption().generateSecurePassword(users.password, salt)
        users.password = hashedPassword
        users.secretKey = salt
        users.updateTime = LocalDateTime.now()

        return userRepository.saveAndFlush(users)
    }

    override fun remove(uId: Int): Int {
        var row: Int = 0
        row = try {
            userRepository.deleteById(uId)
            1
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            0
        }

        return row
    }
}