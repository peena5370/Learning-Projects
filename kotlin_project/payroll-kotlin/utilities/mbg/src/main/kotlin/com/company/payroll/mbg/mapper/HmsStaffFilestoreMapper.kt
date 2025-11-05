package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsStaffFilestore
import org.springframework.stereotype.Repository

@Repository
interface HmsStaffFilestoreMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsStaffFilestore): Int
    fun insertSelective(row: HmsStaffFilestore): Int
    fun selectByPrimaryKey(id: Long): HmsStaffFilestore
    fun updateByPrimaryKeySelective(row: HmsStaffFilestore): Int
    fun updateByPrimaryKey(row: HmsStaffFilestore): Int
}