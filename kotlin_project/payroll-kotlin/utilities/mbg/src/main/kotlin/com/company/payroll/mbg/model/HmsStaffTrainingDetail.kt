package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg
import java.time.LocalDateTime

@NoArg
data class HmsStaffTrainingDetail(var id: Long,
                                  var staffId: Long,
                                  var trainingTitle: String?,
                                  var trainingDescription: String?,
                                  var startDate: LocalDateTime?,
                                  var endDate: LocalDateTime?,
                                  var modifiedDate: LocalDateTime,
                                  var modifiedBy: Long)
