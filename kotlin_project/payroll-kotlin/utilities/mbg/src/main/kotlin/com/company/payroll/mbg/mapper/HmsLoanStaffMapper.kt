package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsLoanStaff
import org.springframework.stereotype.Repository

@Repository
interface HmsLoanStaffMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsLoanStaff): Int
    fun insertSelective(row: HmsLoanStaff): Int
    fun selectByPrimaryKey(id: Long): HmsLoanStaff
    fun updateByPrimaryKeySelective(row: HmsLoanStaff): Int
    fun updateByPrimaryKey(row: HmsLoanStaff): Int
}