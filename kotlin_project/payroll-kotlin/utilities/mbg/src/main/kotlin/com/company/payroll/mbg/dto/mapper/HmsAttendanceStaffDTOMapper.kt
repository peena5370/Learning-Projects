package com.company.payroll.mbg.dto.mapper

import com.company.payroll.mbg.dto.HmsAttendanceStaffDTO
import com.company.payroll.mbg.model.HmsAttendanceStaff


object HmsAttendanceStaffDTOMapper: AbstractDTOClass<HmsAttendanceStaff, HmsAttendanceStaffDTO>()
{
    override fun toDTO(t: HmsAttendanceStaff): HmsAttendanceStaffDTO
    {
        return HmsAttendanceStaffDTO(t.staffId, t.attendanceOrder, t.updateDate);
    }
}