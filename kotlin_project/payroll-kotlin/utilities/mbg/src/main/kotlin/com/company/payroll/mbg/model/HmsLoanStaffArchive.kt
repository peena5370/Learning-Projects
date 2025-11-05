package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@NoArg
data class HmsLoanStaffArchive(var id: Long,
                               var loanId: Long,
                               var referenceNum: String,
                               var reason: String?,
                               var amount: BigDecimal?,
                               var dateRepayFrom: LocalDate?,
                               var dateRepayTo: LocalDate?,
                               var repayBalance: BigDecimal?,
                               var applyDate: LocalDate,
                               var approvedDate: LocalDate?,
                               var status: UByte,
                               var staffId: Long,
                               var modifiedDate: LocalDateTime,
                               var modifiedBy: Long)
