package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsTimeoffStaff
import org.springframework.stereotype.Repository

@Repository
interface HmsTimeoffStaffMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsTimeoffStaff): Int
    fun insertSelective(row: HmsTimeoffStaff): Int
    fun selectByPrimaryKey(id: Long): HmsTimeoffStaff
    fun updateByPrimaryKeySelective(row: HmsTimeoffStaff): Int
    fun updateByPrimaryKey(row: HmsTimeoffStaff): Int
}