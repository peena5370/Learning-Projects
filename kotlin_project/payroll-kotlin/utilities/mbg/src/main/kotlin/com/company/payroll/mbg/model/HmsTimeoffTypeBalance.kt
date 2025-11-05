package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.time.LocalDateTime

@NoArg
data class HmsTimeoffTypeBalance(var id: Long,
                                 var timeoffTypeId: Long,
                                 var staffId: Long,
                                 var typeBalance: Int,
                                 var modifiedDate: LocalDateTime,
                                 var modifiedBy: Long)
