package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.time.LocalDateTime

@NoArg
data class HmsDepartmentRegion(var id: Long?,
                               var regionCode: String,
                               var regionName: String,
                               var modifiedDate: LocalDateTime,
                               var modifiedBy: Long?)
