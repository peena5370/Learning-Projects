package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.time.LocalDateTime

@NoArg
data class HmsPositionStaff(var id: Long,
                            var positionId: Long,
                            var staffId: Long,
                            var positionOrder: Int,
                            var modifiedDate: LocalDateTime,
                            var modifiedBy: Long)
