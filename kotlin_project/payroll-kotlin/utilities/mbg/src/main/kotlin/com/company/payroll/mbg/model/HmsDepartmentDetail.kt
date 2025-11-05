package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.time.LocalDate
import java.time.LocalDateTime

@NoArg
data class HmsDepartmentDetail(var id: Long?,
                               var departmentName: String,
                               var locationAddress: String,
                               var dateFormed: LocalDate,
                               var dateClosed: LocalDate?,
                               var regionId: Long,
                               var modifiedDate: LocalDateTime,
                               var modifiedBy: Long?,
                               var hmsDepartmentRegion: HmsDepartmentRegion?)
