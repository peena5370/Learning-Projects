package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@NoArg
data class HmsPayrollStaff(var id: Long,
                           var salaryId: Long,
                           var staffId: Long,
                           var overtimePay: BigDecimal,
                           var allowanceMisc: BigDecimal,
                           var allowanceTransport: BigDecimal,
                           var deductionLoan: BigDecimal,
                           var deductionOther: BigDecimal,
                           var employeeEpf: BigDecimal,
                           var employeeSocso: BigDecimal,
                           var employeeEis: BigDecimal,
                           var employerEpf: BigDecimal,
                           var employerSocso: BigDecimal,
                           var employerEis: BigDecimal,
                           var mtdPcb: BigDecimal,
                           var netPay: BigDecimal,
                           var payrollPeriod: String,
                           var dateIssue: LocalDate,
                           var modifiedDate: LocalDateTime,
                           var modifiedBy: Long)
