package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsTimeoffTypeBalance
import org.springframework.stereotype.Repository

@Repository
interface HmsTimeoffTypeBalanceMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsTimeoffTypeBalance): Int
    fun insertSelective(row: HmsTimeoffTypeBalance): Int
    fun selectByPrimaryKey(id: Long): HmsTimeoffTypeBalance
    fun updateByPrimaryKeySelective(row: HmsTimeoffTypeBalance): Int
    fun updateByPrimaryKey(row: HmsTimeoffTypeBalance): Int
}