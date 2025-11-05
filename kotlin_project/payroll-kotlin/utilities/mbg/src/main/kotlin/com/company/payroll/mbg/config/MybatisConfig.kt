package com.company.payroll.mbg.config

import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@MapperScan("com.company.payroll.mbg.mapper")
class MybatisConfig
{}