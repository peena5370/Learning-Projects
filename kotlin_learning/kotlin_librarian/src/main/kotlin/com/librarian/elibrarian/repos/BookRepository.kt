package com.librarian.elibrarian.repos

import com.librarian.elibrarian.model.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository: JpaRepository<Book, Int> {
}