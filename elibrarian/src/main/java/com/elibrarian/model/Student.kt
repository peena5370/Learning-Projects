package com.librarian.elibrarian.model

import jakarta.persistence.*

@Entity
@Table(name="e_students")
data class Student(
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="stud_id")
        var studId: Int,
        @Column(name="stud_name", nullable=false)
        var studName: String?,
        @Column(name="stud_phone")
        var studPhone: String?,
        @Column(name="stud_email")
        var studEmail: String?
)
