package com.company.payroll.mbg.dto.mapper

import com.company.payroll.mbg.dto.HmsDepartmentRegionDTO
import com.company.payroll.mbg.model.HmsDepartmentRegion

object HmsDepartmentRegionDTOMapper: AbstractDTOClass<HmsDepartmentRegion, HmsDepartmentRegionDTO>()
{
    override fun toDTO(t: HmsDepartmentRegion): HmsDepartmentRegionDTO
    {
        return HmsDepartmentRegionDTO(t.id, t.regionCode, t.regionName);
    }
}