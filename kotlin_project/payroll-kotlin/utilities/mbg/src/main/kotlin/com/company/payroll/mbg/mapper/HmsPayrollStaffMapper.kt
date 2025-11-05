package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsPayrollStaff
import org.springframework.stereotype.Repository

@Repository
interface HmsPayrollStaffMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsPayrollStaff): Int
    fun insertSelective(row: HmsPayrollStaff): Int
    fun selectByPrimaryKey(id: Long): HmsPayrollStaff
    fun updateByPrimaryKeySelective(row: HmsPayrollStaff): Int
    fun updateByPrimaryKey(row: HmsPayrollStaff): Int
}