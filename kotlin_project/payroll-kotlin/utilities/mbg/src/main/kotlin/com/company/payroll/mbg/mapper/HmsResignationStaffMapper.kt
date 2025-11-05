package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsResignationStaff
import org.springframework.stereotype.Repository

@Repository
interface HmsResignationStaffMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsResignationStaff): Int
    fun insertSelective(row: HmsResignationStaff): Int
    fun selectByPrimaryKey(id: Long): HmsResignationStaff
    fun updateByPrimaryKeySelective(row: HmsResignationStaff): Int
    fun updateByPrimaryKey(row: HmsResignationStaff): Int
}