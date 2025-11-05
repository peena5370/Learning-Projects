package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.time.LocalDate
import java.time.LocalDateTime

@NoArg
data class HmsAttendanceStaff(var id: Long,
                              var attendanceDate: LocalDate,
                              var updateDate: LocalDateTime,
                              var attendanceOrder: Int,
                              var staffId: Long)
