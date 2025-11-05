package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.AmsAccountStaff
import org.springframework.stereotype.Repository

@Repository
interface AmsAccountStaffMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: AmsAccountStaff): Int
    fun insertSelective(row: AmsAccountStaff): Int
    fun selectByPrimaryKey(id: Long): AmsAccountStaff
    fun selectByUsername(username: String): AmsAccountStaff
    fun updateByPrimaryKeySelective(row: AmsAccountStaff): Int
    fun updateByPrimaryKey(row: AmsAccountStaff): Int
}