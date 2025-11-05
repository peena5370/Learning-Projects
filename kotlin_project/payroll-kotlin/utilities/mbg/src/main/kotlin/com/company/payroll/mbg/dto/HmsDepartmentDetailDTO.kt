package com.company.payroll.mbg.dto

import java.time.LocalDate

data class HmsDepartmentDetailDTO(var id: Long?,
                                  var departmentName: String,
                                  var locationAddress: String,
                                  var dateFormed: LocalDate,
                                  var dateClosed: LocalDate?,
                                  var regionId: Long,
                                  var regionCode: String?,
                                  var regionName: String?)
