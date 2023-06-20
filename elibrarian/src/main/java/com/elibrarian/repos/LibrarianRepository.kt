package com.librarian.elibrarian.repos

import com.librarian.elibrarian.model.Librarian
import org.springframework.data.jpa.repository.JpaRepository

interface LibrarianRepository: JpaRepository<Librarian, Int> {
}