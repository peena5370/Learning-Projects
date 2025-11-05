package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.AmsAccountStaffProfile
import com.company.payroll.mbg.model.HmsStaffDetail
import org.springframework.stereotype.Repository

@Repository
interface HmsStaffDetailMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsStaffDetail): Int
    fun insertSelective(row: HmsStaffDetail): Int
    fun selectByPrimaryKey(id: Long): HmsStaffDetail
    fun updateByPrimaryKeySelective(row: HmsStaffDetail): Int
    fun updateByPrimaryKey(row: HmsStaffDetail): Int
}