package com.company.payroll.mbg.dto.mapper

import com.company.payroll.mbg.dto.HmsPositionDetailDTO
import com.company.payroll.mbg.model.HmsPositionDetail

object HmsPositionDetailDTOMapper: AbstractDTOClass<HmsPositionDetail, HmsPositionDetailDTO>()
{
    override fun toDTO(t: HmsPositionDetail): HmsPositionDetailDTO
    {
        return HmsPositionDetailDTO(t.id, t.name, t.description);
    }
}