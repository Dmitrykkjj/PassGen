package org.example.passgen.configs;

import org.example.passgen.annotations.EnableLoggingFilter;
import org.example.passgen.logger.LoggingFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean(annotation = EnableLoggingFilter.class)
public class LoggingFilterConfig {
    @Bean
    public LoggingFilter loggingFilter() {
        return new LoggingFilter();
    }
}
