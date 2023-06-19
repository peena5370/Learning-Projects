package com.librarian.elibrarian

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ElibrarianApplication

fun main(args: Array<String>) {
	runApplication<ElibrarianApplication>(*args)
}
