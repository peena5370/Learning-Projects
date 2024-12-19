package com.librarian.elibrarian.model

import jakarta.persistence.*
import lombok.Data
import java.time.LocalDateTime

@Entity
@Table(name="e_issuebooks")
data class IssueBook(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="issue_id")
        var issueId: Int,
        @Column(name="issued_date")
        var issueDate: LocalDateTime,
        @Column(name="return_status")
        var returnStatus: String,
        @ManyToOne
        @JoinColumn(name="book_id")
        var book: Book,
        @ManyToOne
        @JoinColumn(name="stud_id")
        var student: Student
)
