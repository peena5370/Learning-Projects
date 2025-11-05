package com.company.payroll.security.config

import com.company.payroll.security.interceptor.ApiInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class InterceptorConfig: WebMvcConfigurer
{
    override fun addInterceptors(registry: InterceptorRegistry)
    {
        registry.addInterceptor(ApiInterceptor()).addPathPatterns("/api/**")
            .excludePathPatterns("/api/users/login", "/v3/api-docs/**", "/swagger-ui/**").order(2)
    }
}