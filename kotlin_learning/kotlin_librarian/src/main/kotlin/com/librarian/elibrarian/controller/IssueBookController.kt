package com.librarian.elibrarian.controller

import com.librarian.elibrarian.model.IssueBook
import com.librarian.elibrarian.service.IssueBookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/api/issuebook")
class IssueBookController(@Autowired private val issueBookService: IssueBookService) {

    @PostMapping
    fun issueBook(@RequestBody issueBook: IssueBook): ResponseEntity<IssueBook> {
        return ResponseEntity.ok(issueBookService.issueBook(issueBook))
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<IssueBook>> {
        return ResponseEntity.ok(issueBookService.getAll())
    }

    @GetMapping("{id}")
    fun getById(@PathVariable id: Int): ResponseEntity<Optional<IssueBook>> {
        return ResponseEntity.ok(issueBookService.getById(id))
    }

    @PutMapping("/{id}")
    fun returnBook(@RequestBody issueBook: IssueBook): ResponseEntity<IssueBook> {
        return ResponseEntity.ok(issueBookService.returnBook(issueBook))
    }
}