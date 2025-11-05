package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsAttendanceStaffArchive
import org.springframework.stereotype.Repository

@Repository
interface HmsAttendanceStaffArchiveMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsAttendanceStaffArchive): Int
    fun insertSelective(row: HmsAttendanceStaffArchive): Int
    fun selectByPrimaryKey(id: Long): HmsAttendanceStaffArchive
    fun updateByPrimaryKeySelective(row: HmsAttendanceStaffArchive): Int
    fun updateByPrimaryKey(row: HmsAttendanceStaffArchive): Int
}