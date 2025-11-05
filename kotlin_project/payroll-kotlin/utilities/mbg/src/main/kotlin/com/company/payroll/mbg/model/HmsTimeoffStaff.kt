package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.time.LocalDate
import java.time.LocalDateTime

@NoArg
data class HmsTimeoffStaff(var id: Long,
                           var timeoffReferenceNum: String,
                           var timeoffTypeId: Long,
                           var reason: String?,
                           var applyDate: LocalDate,
                           var approvedDate: LocalDate?,
                           var startDate: LocalDateTime,
                           var endDate: LocalDateTime,
                           var status: UByte,
                           var staffId: Long,
                           var modifiedDate: LocalDateTime,
                           var modifiedBy: Long)
