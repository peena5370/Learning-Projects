package com.company.payroll.position.service

import com.company.payroll.mbg.dto.HmsPositionDetailDTO
import com.company.payroll.mbg.model.HmsPositionDetail
import com.company.payroll.mbg.model.HmsPositionStaff

interface HmsPositionService {
    /**
     * @param id
     * @return object
     */
    fun getPositionDetailById(id: Long): HmsPositionDetailDTO?

    /**
     * @param name
     * @return object
     */
    fun getPositionDetailByName(name: String): HmsPositionDetailDTO?

    /**
     * @param hmsPositionDetail
     * @return Int
     */
    fun createPositionDetail(hmsPositionDetail: HmsPositionDetail): Int

    /**
     * @param hmsPositionDetail
     * @return Int
     */
    fun updatePositionDetail(hmsPositionDetail: HmsPositionDetail): Int

    /**
     * @param id
     * @return Int
     */
    fun deletePositionDetailById(id: Long): Int

    /**
     * @param staffId
     * @param sortOrder
     * @return List<HmsPositionStaff>
     */
    fun getStaffPositionDetailByOrder(staffId: Long, sortOrder: String): List<HmsPositionStaff>

    /**
     * @param positionDetailId
     * @return List<HmsPositionStaff>
     */
    fun getStaffPositionDetailByPositionDetailId(positionDetailId: Long): List<HmsPositionStaff>?

    /**
     * @param hmsPositionStaff
     * @return Int
     */
    fun insertStaffPosition(hmsPositionStaff: HmsPositionStaff): Int

    /**
     * @param hmsPositionStaffs
     * @return Int
     */
    fun updateStaffPositions(hmsPositionStaffs: List<HmsPositionStaff>): Int

    /**
     * @param id
     * @return Int
     */
    fun deleteStaffPosition(id: Long): Int
}