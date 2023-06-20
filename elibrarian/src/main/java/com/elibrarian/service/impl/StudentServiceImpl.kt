package com.librarian.elibrarian.service.impl

import com.librarian.elibrarian.model.Student
import com.librarian.elibrarian.repos.StudentRepository
import com.librarian.elibrarian.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class StudentServiceImpl(@Autowired private val studentRepository: StudentRepository): StudentService {
    override fun create(student: Student): Student {
        return studentRepository.saveAndFlush(student)
    }

    override fun list(): List<Student> {
        return studentRepository.findAll().toList()
    }

    override fun getById(studId: Int): Optional<Student> {
        return studentRepository.findById(studId)
    }

    override fun update(student: Student): Student {
        return studentRepository.saveAndFlush(student)
    }

    override fun remove(studId: Int): Int {
        var row: Int = 0
        row = try {
            studentRepository.deleteById(studId)
            1
        } catch(e: IllegalArgumentException) {
            e.printStackTrace()
            0
        }

        return row
    }
}