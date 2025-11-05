package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsAttendanceStaff
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface HmsAttendanceStaffMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsAttendanceStaff): Int
    fun insertSelective(row: HmsAttendanceStaff): Int
    fun selectByStaffIdAndAttendanceDate(staffId: Long, attendanceDate: LocalDate): List<HmsAttendanceStaff>?
    fun selectByStaffIdAndDateRange(@Param("staffId") staffId: Long,
                                    @Param("dateStart") dateStart: LocalDate,
                                    @Param("dateEnd") dateEnd: LocalDate,
                                    @Param("offset") offset: Int,
                                    @Param("limit") limit: Int): List<HmsAttendanceStaff>?

    fun selectByPrimaryKey(id: Long): HmsAttendanceStaff
    fun updateByPrimaryKeySelective(row: HmsAttendanceStaff): Int
    fun updateByPrimaryKey(row: HmsAttendanceStaff): Int
}