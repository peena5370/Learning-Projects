package com.company.payroll.department.service

import com.company.payroll.mbg.dto.HmsDepartmentDetailDTO
import com.company.payroll.mbg.dto.HmsDepartmentRegionDTO
import com.company.payroll.mbg.model.HmsDepartmentDetail
import com.company.payroll.mbg.model.HmsDepartmentLeader
import com.company.payroll.mbg.model.HmsDepartmentRegion
import com.company.payroll.mbg.model.HmsDepartmentStaff

interface HmsDepartmentService
{
    /**
     * @param offset
     * @param limit
     * @return List<HmsDepartmentDetail>
     */
    fun getAllDepartmentDetailBySortFieldAndOffsetAndLimit(field: String?,
                                                           sort: String?,
                                                           offset: Int?,
                                                           limit: Int?): List<HmsDepartmentDetailDTO>?

    /**
     * @param id
     * @return HmsDepartmentDetailDTO
     */
    fun getDepartmentDetailById(id: Long): HmsDepartmentDetailDTO?

    /**
     * @param departmentName
     * @return HmsDepartmentDetailDTO
     */
    fun getDepartmentDetailByDepartmentName(departmentName: String): HmsDepartmentDetailDTO?

    /**
     * @param hmsDepartmentDetail
     * @return Int
     */
    fun createDepartmentDetail(hmsDepartmentDetail: HmsDepartmentDetail): Int

    /**
     * @param hmsDepartmentDetail
     * @return Int
     */
    fun updateDepartmentDetailById(hmsDepartmentDetail: HmsDepartmentDetail): Int

    /**
     * @param id
     * @return Int
     */
    fun deleteDepartmentDetailById(id: Long): Int

    /**
     * @param leaderId
     * @return HmsDepartmentLeader
     */
    fun getDepartmentDetailByLeaderId(leaderId: Long): HmsDepartmentLeader?

    /**
     * @param departmentId
     * @return List<HmsDepartmentLeader>
     */
    fun getDepartmentLeadersByDepartmentId(departmentId: Long): List<HmsDepartmentLeader>?

    /**
     * @param departmentId
     * @param leaderId
     * @return Int
     */
    fun addDepartmentLeader(departmentId: Long, leaderId: Long): Int

    /**
     * @param departmentId
     * @param leaderIds
     * @return Int
     */
    fun addDepartmentLeaders(departmentId: Long, leaderIds: List<Long>): Int

    /**
     * @param departmentId
     * @param leaderId
     * @return Int
     */
    fun deleteDepartmentLeaderByDepartmentIdAndLeaderId(departmentId: Long, leaderId: Long): Int

    /**
     * @param departmentId
     * @param leaderIds
     * @return Int
     */
    fun deleteDepartmentLeadersByDepartmentIdAndLeaderIds(departmentId: Long, leaderIds: List<Long>): Int

    /**
     * @param id
     * @return HmsDepartmentRegion
     */
    fun getDepartmentRegionById(id: Long): HmsDepartmentRegionDTO?

    /**
     * @param regionCode
     * @return HmsDepartmentRegion
     */
    fun getDepartmentRegionByRegionCode(regionCode: String): HmsDepartmentRegion?

    /**
     * @param field
     * @param sort
     * @param offset
     * @param limit
     */
    fun getDepartmentRegionBySortFieldAndOffsetAndLimit(field: String?,
                                                        sort: String?,
                                                        offset: Int?,
                                                        limit: Int?): List<HmsDepartmentRegionDTO>?

    /**
     * @param hmsDepartmentRegion
     * @return Int
     */
    fun createDepartmentRegion(hmsDepartmentRegion: HmsDepartmentRegion): Int

    /**
     * @param hmsDepartmentRegion
     * @return Int
     */
    fun updateDepartmentRegion(hmsDepartmentRegion: HmsDepartmentRegion): Int

    /**
     * @param id
     * @return Int
     */
    fun deleteDepartmentRegionById(id: Long): Int

    /**
     * @param staffId
     * @return HmsDepartmentStaff
     */
    fun getDepartmentStaffByStaffId(staffId: Long): HmsDepartmentStaff

    /**
     * @param departmentId
     * @return List<HmsDepartmentStaff>
     */
    fun getDepartmentStaffsByDepartmentId(departmentId: Long): List<HmsDepartmentStaff>?

    /**
     * @param departmentId
     * @param staffId
     * @return Int
     */
    fun addDepartmentStaff(departmentId: Long, staffId: Long): Int

    /**
     * @param departmentId
     * @param staffIds
     * @return Int
     */
    fun addDepartmentStaffs(departmentId: Long, staffIds: List<Long>): Int

    /**
     * @param departmentId
     * @param staffId
     * @return Int
     */
    fun deleteDepartmentStaffByDepartmentIdAndStaffId(departmentId: Long, staffId: Long): Int

    /**
     * @param departmentId
     * @param staffIds
     * @return Int
     */
    fun deleteDepartmentStaffsByDepartmentIdAndStaffIds(departmentId: Long, staffIds: List<Long>): Int
}