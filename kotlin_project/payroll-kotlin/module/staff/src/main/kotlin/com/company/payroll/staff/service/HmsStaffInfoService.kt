package com.company.payroll.staff.service

import com.company.payroll.mbg.model.HmsStaffDetail
import com.company.payroll.mbg.model.HmsPositionStaff

interface HmsStaffInfoService {

    /**
     * @param staffId
     * @return HmsStaffDetail
     */
    fun findStaffById(staffId: Long): HmsStaffDetail?

    /**
     * @param staffJobTitle
     * @return Int
     */
    fun insertStaffJobTitle(staffJobTitle: HmsPositionStaff): Int
}