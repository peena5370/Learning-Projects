package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.AmsAccountCredential
import org.springframework.stereotype.Repository

@Repository
interface AmsAccountCredentialMapper
{
    fun selectByPrimaryKey(id: Long): AmsAccountCredential
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: AmsAccountCredential): Int
    fun insertSelective(row: AmsAccountCredential): Int
    fun updateByPrimaryKeySelective(row: AmsAccountCredential): Int
    fun updateByPrimaryKey(row: AmsAccountCredential): Int
}