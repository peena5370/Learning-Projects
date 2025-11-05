package com.company.payroll.config.service

import com.company.payroll.mbg.model.HmsConfig

interface HmsConfigService
{
    /**
     * @return List<HmsConfig>
     */
    fun getAllConfigSetup(): List<HmsConfig>?

    /**
     * @param configType
     * @return List<HmsConfig>
     */
    fun getAllConfigByType(configType: String): List<HmsConfig>?

    /**
     * @param hmsConfig
     * @return Int
     */
    fun updateConfigById(hmsConfig: HmsConfig): Int
}