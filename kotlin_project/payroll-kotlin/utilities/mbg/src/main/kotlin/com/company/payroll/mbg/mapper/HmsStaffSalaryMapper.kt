package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsStaffSalary
import org.springframework.stereotype.Repository

@Repository
interface HmsStaffSalaryMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsStaffSalary): Int
    fun insertSelective(row: HmsStaffSalary): Int
    fun selectByPrimaryKey(id: Long): HmsStaffSalary
    fun updateByPrimaryKeySelective(row: HmsStaffSalary): Int
    fun updateByPrimaryKey(row: HmsStaffSalary): Int
}