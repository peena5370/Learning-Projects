package com.company.payroll.mbg.dto.mapper

import com.company.payroll.mbg.dto.HmsDepartmentDetailDTO
import com.company.payroll.mbg.model.HmsDepartmentDetail

object HmsDepartmentDetailDTOMapper: AbstractDTOClass<HmsDepartmentDetail, HmsDepartmentDetailDTO>()
{
    override fun toDTO(t: HmsDepartmentDetail): HmsDepartmentDetailDTO
    {
        return HmsDepartmentDetailDTO(t.id,
                                      t.departmentName,
                                      t.locationAddress,
                                      t.dateFormed,
                                      t.dateClosed,
                                      t.regionId,
                                      t.hmsDepartmentRegion?.regionCode,
                                      t.hmsDepartmentRegion?.regionName);
    }
}