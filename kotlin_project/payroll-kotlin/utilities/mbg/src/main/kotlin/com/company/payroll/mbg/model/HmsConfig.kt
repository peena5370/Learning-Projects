package com.company.payroll.mbg.model

import com.company.payroll.mbg.annotation.NoArg

@NoArg
data class HmsConfig(var id: Long, var configType: String, var name: String, var value: String)
