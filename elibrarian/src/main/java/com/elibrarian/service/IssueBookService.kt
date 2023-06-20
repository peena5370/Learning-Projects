package com.librarian.elibrarian.service

import com.librarian.elibrarian.model.IssueBook
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.util.*

interface IssueBookService {
    @Transactional(rollbackFor = [Exception::class], propagation = Propagation.REQUIRES_NEW)
    fun issueBook(issueBook: IssueBook): IssueBook?
    fun getAll(): List<IssueBook>
    fun getById(issueId: Int): Optional<IssueBook>
    @Transactional(rollbackFor = [Exception::class], propagation = Propagation.REQUIRES_NEW)
    fun returnBook(issueBook: IssueBook): IssueBook?
}