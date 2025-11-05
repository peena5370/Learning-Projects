package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsConfig
import org.springframework.stereotype.Repository

@Repository
interface HmsConfigMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsConfig): Int
    fun insertSelective(row: HmsConfig): Int
    fun selectAll(): List<HmsConfig>?
    fun selectByConfigType(configType: String): List<HmsConfig>?
    fun selectByPrimaryKey(id: Long): HmsConfig
    fun updateByPrimaryKeySelective(row: HmsConfig): Int
    fun updateByPrimaryKey(row: HmsConfig): Int
}