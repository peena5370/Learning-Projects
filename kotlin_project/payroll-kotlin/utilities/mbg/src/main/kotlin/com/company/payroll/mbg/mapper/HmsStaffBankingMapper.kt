package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsStaffBanking
import org.springframework.stereotype.Repository

@Repository
interface HmsStaffBankingMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsStaffBanking): Int
    fun insertSelective(row: HmsStaffBanking): Int
    fun selectByPrimaryKey(id: Long): HmsStaffBanking
    fun updateByPrimaryKeySelective(row: HmsStaffBanking): Int
    fun updateByPrimaryKey(row: HmsStaffBanking): Int
}