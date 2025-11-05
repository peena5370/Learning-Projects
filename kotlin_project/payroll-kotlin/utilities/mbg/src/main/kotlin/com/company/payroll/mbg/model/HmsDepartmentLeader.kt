package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.time.LocalDateTime

@NoArg
data class HmsDepartmentLeader(var id: Long,
                               var departmentId: Long,
                               var staffId: Long,
                               var modifiedDate: LocalDateTime,
                               var modifiedBy: Long)
