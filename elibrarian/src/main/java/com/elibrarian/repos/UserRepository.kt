package com.librarian.elibrarian.repos

import com.librarian.elibrarian.model.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface UserRepository: JpaRepository<Users, Int> {

    @Query(value="select * from e_users where username like ?1", nativeQuery=true)
    fun findByUsername(username: String): Optional<Users>
}