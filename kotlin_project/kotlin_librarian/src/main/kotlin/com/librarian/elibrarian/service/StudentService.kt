package com.librarian.elibrarian.service

import com.librarian.elibrarian.model.Student
import java.util.*

interface StudentService {
    fun create(student: Student): Student
    fun list(): List<Student>
    fun getById(studId: Int): Optional<Student>
    fun update(student: Student): Student
    fun remove(studId: Int): Int
}