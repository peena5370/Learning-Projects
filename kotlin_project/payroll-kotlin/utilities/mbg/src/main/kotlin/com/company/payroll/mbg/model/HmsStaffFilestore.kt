package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.time.LocalDateTime

@NoArg
data class HmsStaffFilestore(var id: Long,
                             var fileName: String,
                             var fileSize: Long,
                             var fileType: String,
                             var filePath: String,
                             var fileTableType: String,
                             var staffId: Long,
                             var modifiedDate: LocalDateTime,
                             var modifiedBy: Long)
