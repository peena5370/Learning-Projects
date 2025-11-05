package com.company.payroll.config.service.impl

import com.company.payroll.config.service.HmsConfigService
import com.company.payroll.mbg.mapper.HmsConfigMapper
import com.company.payroll.mbg.model.HmsConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HmsConfigServiceImpl(@Autowired private val hmsConfigMapper: HmsConfigMapper): HmsConfigService
{
    override fun getAllConfigSetup(): List<HmsConfig>?
    {
        return hmsConfigMapper.selectAll();
    }

    override fun getAllConfigByType(configType: String): List<HmsConfig>?
    {
        return hmsConfigMapper.selectByConfigType(configType);
    }

    override fun updateConfigById(hmsConfig: HmsConfig): Int
    {
        return hmsConfigMapper.updateByPrimaryKey(hmsConfig);
    }
}