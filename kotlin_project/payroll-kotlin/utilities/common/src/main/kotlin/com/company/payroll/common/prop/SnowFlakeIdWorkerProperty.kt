package com.company.payroll.common.prop

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("util")
data class SnowFlakeIdWorkerProperty(@Value("util.workerId") var workerId: String,
                                     @Value("util.datacenterId") var datacenterId: String)