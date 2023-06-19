package com.librarian.elibrarian.model

import jakarta.persistence.*
import lombok.Data

@Data
@Entity
@Table(name="e_student")
data class Student(
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="stud_id")
        val studId: Int,
        @Column(name="stud_name", nullable=false)
        val studName: String,
        @Column(name="stud_phone")
        val studPhone: String,
        @Column(name="stud_email")
        val studEmail: String
)
