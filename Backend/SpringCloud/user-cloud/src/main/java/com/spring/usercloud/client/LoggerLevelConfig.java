package com.spring.usercloud.client;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class LoggerLevelConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
