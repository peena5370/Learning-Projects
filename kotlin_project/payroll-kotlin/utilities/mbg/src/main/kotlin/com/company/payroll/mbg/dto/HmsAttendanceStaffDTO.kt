package com.company.payroll.mbg.dto

import java.time.LocalDateTime

data class HmsAttendanceStaffDTO(var staffId: Long, var attendanceOrder: Int, var updateDate: LocalDateTime)