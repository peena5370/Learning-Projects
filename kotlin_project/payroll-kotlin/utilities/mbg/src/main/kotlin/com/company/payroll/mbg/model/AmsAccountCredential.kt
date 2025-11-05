package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.time.LocalDateTime

@NoArg
data class AmsAccountCredential(var id: Long,
                                var accountId: Long,
                                var role: String,
                                var modifiedDate: LocalDateTime,
                                var modifiedBy: Long)
