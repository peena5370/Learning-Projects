package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsPositionDetail
import org.springframework.stereotype.Repository

@Repository
interface HmsPositionDetailMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsPositionDetail): Int
    fun insertSelective(row: HmsPositionDetail): Int
    fun selectByPrimaryKey(id: Long): HmsPositionDetail?
    fun selectByName(id: String): HmsPositionDetail?
    fun updateByPrimaryKeySelective(row: HmsPositionDetail): Int
    fun updateByPrimaryKey(row: HmsPositionDetail): Int
    fun updateByPrimaryKeyWithBLOBs(row: HmsPositionDetail): Int
}