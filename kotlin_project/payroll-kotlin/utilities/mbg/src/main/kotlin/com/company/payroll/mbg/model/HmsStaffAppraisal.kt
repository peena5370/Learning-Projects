package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@NoArg
data class HmsStaffAppraisal(var id: Long,
                             var salaryCurrent: BigDecimal,
                             var salaryAppraised: BigDecimal,
                             var dateAppraisedStart: LocalDate,
                             var comment: String?,
                             var status: UByte,
                             var positionId: Long,
                             var staffId: Long,
                             var modifiedDate: LocalDateTime,
                             var modifiedBy: Long)
