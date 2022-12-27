package com.example.demo.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// CORS policy configuration
@Configuration
public class CorsConfig {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			
		  @Override
		  public void addCorsMappings(CorsRegistry registry) {
		    registry.addMapping("/**")
		    .allowCredentials(true)
		    .allowedOriginPatterns("*")
		    .allowedMethods("GET", "POST", "DELETE", "PUT","PATCH")
		    .maxAge(3600);  
		  }
		};
	}
}
