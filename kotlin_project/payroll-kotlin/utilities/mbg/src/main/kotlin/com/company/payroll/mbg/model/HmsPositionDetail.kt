package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.time.LocalDateTime

@NoArg
data class HmsPositionDetail(var id: Long?,
                             var name: String,
                             var description: String,
                             var modifiedDate: LocalDateTime?,
                             var modifiedBy: Long?)
