package com.company.payroll.mbg.mapper

import com.company.payroll.mbg.model.HmsDepartmentDetail
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

@Repository
interface HmsDepartmentDetailMapper
{
    fun deleteByPrimaryKey(id: Long): Int
    fun insert(row: HmsDepartmentDetail): Int
    fun insertSelective(row: HmsDepartmentDetail): Int
    fun selectByPrimaryKey(id: Long): HmsDepartmentDetail?
    fun selectByDepartmentName(departmentName: String): HmsDepartmentDetail?
    fun selectAllByOffsetAndLimit(@Param("field") field: String,
                                  @Param("sort") sort: String,
                                  @Param("offset") offset: Int,
                                  @Param("limit") limit: Int): List<HmsDepartmentDetail>?

    fun updateByPrimaryKeySelective(row: HmsDepartmentDetail): Int
    fun updateByPrimaryKey(row: HmsDepartmentDetail): Int
}