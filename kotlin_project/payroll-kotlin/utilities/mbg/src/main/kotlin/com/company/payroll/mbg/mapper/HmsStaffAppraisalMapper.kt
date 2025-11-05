package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsStaffAppraisal
import org.springframework.stereotype.Repository

@Repository
interface HmsStaffAppraisalMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsStaffAppraisal): Int
    fun insertSelective(row: HmsStaffAppraisal): Int
    fun selectByPrimaryKey(id: Long): HmsStaffAppraisal
    fun updateByPrimaryKeySelective(row: HmsStaffAppraisal): Int
    fun updateByPrimaryKey(row: HmsStaffAppraisal): Int
}