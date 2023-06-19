package com.librarian.elibrarian.controller

import com.librarian.elibrarian.model.Student
import com.librarian.elibrarian.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/student")
class StudentController(@Autowired private val studentService: StudentService) {

    @PostMapping
    fun addStudent(@RequestBody student: Student): ResponseEntity<Student> {
        return ResponseEntity.ok(studentService.create(student))
    }

    @GetMapping
    fun getList(): ResponseEntity<List<Student>> =
            ResponseEntity.ok(studentService.list())

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): ResponseEntity<Optional<Student>> {
        return ResponseEntity.ok(studentService.getById(id))
    }

    @PutMapping("/{id}")
    fun updateStudent(@RequestBody student: Student): ResponseEntity<Student> {
        return ResponseEntity.ok(studentService.update(student))
    }

    @DeleteMapping("{id}")
    fun deleteStudent(@PathVariable id: Int): ResponseEntity<Int> {
        return ResponseEntity.ok(studentService.remove(id))
    }
}