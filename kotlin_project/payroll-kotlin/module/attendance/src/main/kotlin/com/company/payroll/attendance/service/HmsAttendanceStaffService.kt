package com.company.payroll.attendance.service

import com.company.payroll.mbg.dto.HmsAttendanceStaffDTO
import java.time.LocalDate

interface HmsAttendanceStaffService
{
    /**
     * @param staffId
     * @return Int
     */
    fun insertAttendanceByStaffId(staffId: Long): Int

    /**
     * @param staffId
     * @param dateStart
     * @param dateEnd
     * @param offset
     * @param limit
     * @return List<HmsAttendanceStaffDTO>
     */
    fun getAttendanceByStaffIdAndDateRange(staffId: Long,
                                           dateStart: LocalDate,
                                           dateEnd: LocalDate,
                                           offset: Int?,
                                           limit: Int?): List<HmsAttendanceStaffDTO>?

    /**
     * @since v1.0 Date: 12-July-2024 to be implemented
     * @param staffId
     * @param dateStart
     * @param dateEnd
     * @return Double
     */
    fun getSumOfTotalWorkingHoursForStaffByStaffIdAndDateRange(staffId: Long,
                                                               dateStart: LocalDate,
                                                               dateEnd: LocalDate): Double?
}