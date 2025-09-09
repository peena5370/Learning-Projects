package com.elibrarian.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // minimum pool size
        executor.setMaxPoolSize(10); // maximum pool size
        executor.setQueueCapacity(500);     // Task queue capacity
        executor.setThreadNamePrefix("TaskExecutor-");
        executor.initialize();

        return executor;
    }
}
