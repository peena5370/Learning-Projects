package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.time.LocalDateTime

@NoArg
data class AmsAccountStaffProfile(var id: Long,
                                  var accountId: Long,
                                  var aboutProfile: String?,
                                  var imagePath: String?,
                                  var modifiedDate: LocalDateTime,
                                  var modifiedBy: Long)
