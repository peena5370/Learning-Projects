package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsPositionStaff
import org.springframework.stereotype.Repository

@Repository
interface HmsPositionStaffMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsPositionStaff): Int
    fun insertSelective(row: HmsPositionStaff): Int
    fun selectByPrimaryKey(id: Long): HmsPositionStaff?
    fun selectByPositionId(positionDetailId: Long): List<HmsPositionStaff>?
    fun updateByPrimaryKeySelective(row: HmsPositionStaff): Int
    fun updateByPrimaryKey(row: HmsPositionStaff): Int
}