package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsTimeoffType
import org.springframework.stereotype.Repository

@Repository
interface HmsTimeoffTypeMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsTimeoffType): Int
    fun insertSelective(row: HmsTimeoffType): Int
    fun selectByPrimaryKey(id: Long): HmsTimeoffType
    fun updateByPrimaryKeySelective(row: HmsTimeoffType): Int
    fun updateByPrimaryKey(row: HmsTimeoffType): Int
}