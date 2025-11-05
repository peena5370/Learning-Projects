package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.time.LocalDateTime

@NoArg
data class AmsAccountStaff(var id: Long,
                           var username: String,
                           var password: String,
                           var secretKey: String,
                           var staffId: Long,
                           var lastLogin: LocalDateTime?,
                           var status: UByte,
                           var lastAttempt: Int,
                           var createdDate: LocalDateTime,
                           var modifiedDate: LocalDateTime,
                           var modifiedBy: Long)
