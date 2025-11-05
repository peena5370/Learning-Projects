package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.time.LocalDate
import java.time.LocalDateTime

@NoArg
data class HmsAttendanceStaffArchive(var id: Long,
                                     var attendanceId: Long,
                                     var attendanceDate: LocalDate,
                                     var updateDate: LocalDateTime,
                                     var attendanceOrder: Int,
                                     var staffId: Long)
