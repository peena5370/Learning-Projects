package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsDepartmentStaff
import org.springframework.stereotype.Repository

@Repository
interface HmsDepartmentStaffMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsDepartmentStaff): Int
    fun insertSelective(row: HmsDepartmentStaff): Int
    fun selectByPrimaryKey(id: Long): HmsDepartmentStaff
    fun selectAllByDepartmentId(departmentId: Long): List<HmsDepartmentStaff>?
    fun updateByPrimaryKeySelective(row: HmsDepartmentStaff): Int
    fun updateByPrimaryKey(row: HmsDepartmentStaff): Int
}