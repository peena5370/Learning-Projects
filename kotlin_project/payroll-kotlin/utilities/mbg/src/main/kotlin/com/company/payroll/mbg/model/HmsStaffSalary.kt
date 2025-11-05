package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.math.BigDecimal
import java.time.LocalDateTime

@NoArg
data class HmsStaffSalary(var id: Long,
                          var monthlySalary: BigDecimal,
                          var annualSalary: BigDecimal,
                          var staffId: Long,
                          var modifiedDate: LocalDateTime,
                          var modifiedBy: Long)
