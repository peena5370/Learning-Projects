package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.time.LocalDateTime

@NoArg
data class HmsStaffBanking(var id: Long,
                           var accountNumber: Long?,
                           var bankName: String?,
                           var accountEpf: Int?,
                           var accountIncomeTax: String?,
                           var staffId: Long,
                           var modifiedDate: LocalDateTime,
                           var modifiedBy: Long)
