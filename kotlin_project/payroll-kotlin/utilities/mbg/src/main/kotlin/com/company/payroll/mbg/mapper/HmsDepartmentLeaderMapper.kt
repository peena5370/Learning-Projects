package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsDepartmentLeader
import org.springframework.stereotype.Repository

@Repository
interface HmsDepartmentLeaderMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsDepartmentLeader): Int
    fun insertSelective(row: HmsDepartmentLeader): Int
    fun selectByPrimaryKey(id: Long): HmsDepartmentLeader
    fun selectAllByDepartmentId(departmentId: Long): List<HmsDepartmentLeader>?
    fun updateByPrimaryKeySelective(row: HmsDepartmentLeader): Int
    fun updateByPrimaryKey(row: HmsDepartmentLeader): Int
}