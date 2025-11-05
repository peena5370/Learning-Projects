package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.time.LocalDate
import java.time.LocalDateTime

@NoArg
data class HmsStaffDetail(var id: Long,
                          var staffCode: String,
                          var fullname: String,
                          var gender: String,
                          var dateOfBirth: LocalDate,
                          var age: Int,
                          var icNumber: String,
                          var maritalStatus: String,
                          var education: String,
                          var homeAddress: String?,
                          var phoneHome: String?,
                          var phoneMobile: String?,
                          var emailCompany: String,
                          var hiredDate: LocalDate,
                          var resignDate: LocalDate?,
                          var managerId: Long?,
                          var deletedDate: LocalDateTime?,
                          var modifiedDate: LocalDateTime,
                          var modifiedBy: Long)
