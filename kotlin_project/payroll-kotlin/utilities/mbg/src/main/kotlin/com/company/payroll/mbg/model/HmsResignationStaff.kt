package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.time.LocalDate
import java.time.LocalDateTime

@NoArg
data class HmsResignationStaff(var id: Long,
                               var resignationReferenceNum: String,
                               var reason: String?,
                               var resignDate: LocalDate,
                               var fileId: Long?,
                               var staffId: Long,
                               var modifiedDate: LocalDateTime,
                               var modifiedBy: Long)
