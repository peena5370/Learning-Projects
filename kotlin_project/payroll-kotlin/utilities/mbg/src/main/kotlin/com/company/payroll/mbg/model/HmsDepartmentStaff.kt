package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.time.LocalDateTime

@NoArg
data class HmsDepartmentStaff(var id: Long,
                              var departmentId: Long,
                              var staffId: Long,
                              var deletedDate: LocalDateTime?,
                              var modifiedDate: LocalDateTime,
                              var modifiedBy: Long)
