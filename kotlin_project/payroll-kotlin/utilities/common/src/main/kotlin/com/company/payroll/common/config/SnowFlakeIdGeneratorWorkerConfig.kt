package com.company.payroll.common.config

import com.company.payroll.common.prop.SnowFlakeIdWorkerProperty
import com.company.payroll.common.util.SnowFlakeIdGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SnowFlakeIdGeneratorWorkerConfig(@Autowired private val snowFlakeIdWorkerProperty: SnowFlakeIdWorkerProperty)
{
    @Bean
    fun createSnowFlakeIdGenerator(): SnowFlakeIdGenerator
    {
        return SnowFlakeIdGenerator(snowFlakeIdWorkerProperty.workerId.toLong(),
                                    snowFlakeIdWorkerProperty.datacenterId.toLong())
    }
}