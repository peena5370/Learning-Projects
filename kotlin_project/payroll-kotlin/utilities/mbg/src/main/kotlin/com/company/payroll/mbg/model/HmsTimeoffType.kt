package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.time.LocalDateTime

@NoArg
data class HmsTimeoffType(var id: Long,
                          var typeName: String,
                          var typeDefaultAmount: Int,
                          var modifiedDate: LocalDateTime,
                          var modifiedBy: Long)
