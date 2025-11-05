package com.company.payroll.security.prop

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("jwt.config")
data class JwtTokenProperty(@Value("jwt.config.key") var key: String, @Value("jwt.config.ttl") var ttl: String)
