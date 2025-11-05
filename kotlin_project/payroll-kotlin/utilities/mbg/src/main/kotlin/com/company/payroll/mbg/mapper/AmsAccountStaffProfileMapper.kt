package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.AmsAccountStaffProfile
import org.springframework.stereotype.Repository

@Repository
interface AmsAccountStaffProfileMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: AmsAccountStaffProfile): Int
    fun insertSelective(row: AmsAccountStaffProfile): Int
    fun selectByPrimaryKey(id: Long): AmsAccountStaffProfile
    fun updateByPrimaryKeySelective(row: AmsAccountStaffProfile): Int
    fun updateByPrimaryKey(row: AmsAccountStaffProfile): Int
}