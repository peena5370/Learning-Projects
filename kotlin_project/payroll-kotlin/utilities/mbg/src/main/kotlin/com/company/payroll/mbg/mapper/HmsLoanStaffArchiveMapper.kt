package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsLoanStaffArchive
import org.springframework.stereotype.Repository

@Repository
interface HmsLoanStaffArchiveMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsLoanStaffArchive): Int
    fun insertSelective(row: HmsLoanStaffArchive): Int
    fun selectByPrimaryKey(id: Long): HmsLoanStaffArchive
    fun updateByPrimaryKeySelective(row: HmsLoanStaffArchive): Int
    fun updateByPrimaryKey(row: HmsLoanStaffArchive): Int
}