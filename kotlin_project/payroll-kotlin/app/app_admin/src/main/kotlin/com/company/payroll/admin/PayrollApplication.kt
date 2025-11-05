package com.company.payroll.admin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication(scanBasePackages = ["com.company.payroll"])
class PayrollApplication

fun main(args: Array<String>)
{
    runApplication<PayrollApplication>(*args)
}
