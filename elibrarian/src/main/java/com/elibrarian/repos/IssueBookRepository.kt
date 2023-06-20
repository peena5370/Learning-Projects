package com.librarian.elibrarian.repos

import com.librarian.elibrarian.model.IssueBook
import org.springframework.data.jpa.repository.JpaRepository

interface IssueBookRepository: JpaRepository<IssueBook, Int> {
}