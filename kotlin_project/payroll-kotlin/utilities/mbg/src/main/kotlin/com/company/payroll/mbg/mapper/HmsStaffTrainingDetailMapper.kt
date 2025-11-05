package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsStaffTrainingDetail
import org.springframework.stereotype.Repository

@Repository
interface HmsStaffTrainingDetailMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsStaffTrainingDetail): Int
    fun insertSelective(row: HmsStaffTrainingDetail): Int
    fun selectByPrimaryKey(id: Long): HmsStaffTrainingDetail
    fun updateByPrimaryKeySelective(row: HmsStaffTrainingDetail): Int
    fun updateByPrimaryKey(row: HmsStaffTrainingDetail): Int
}