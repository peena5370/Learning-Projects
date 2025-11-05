package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsDepartmentRegion
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

@Repository
interface HmsDepartmentRegionMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsDepartmentRegion): Int
    fun insertSelective(row: HmsDepartmentRegion): Int
    fun selectByPrimaryKey(id: Long): HmsDepartmentRegion?
    fun selectByRegionCode(regionCode: String): HmsDepartmentRegion?
    fun selectAllByOffsetAndLimit(@Param("field") field: String,
                                  @Param("sort") sort: String,
                                  @Param("offset") offset: Int,
                                  @Param("limit") limit: Int): List<HmsDepartmentRegion>?
    fun updateByPrimaryKeySelective(row: HmsDepartmentRegion): Int
    fun updateByPrimaryKey(row: HmsDepartmentRegion): Int
}