package com.librarian.elibrarian.repos

import org.springframework.data.jpa.repository.JpaRepository
import com.librarian.elibrarian.model.Student

interface StudentRepository: JpaRepository<Student, Int> {
}