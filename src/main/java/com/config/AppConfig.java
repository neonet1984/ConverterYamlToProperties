package com.config;

import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Configuration searches for the service and loads app.properties
 */
@Configuration
@EnableScheduling
@ComponentScan("com.service")
@PropertySources({
        @PropertySource(value = "classpath:app.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "file:./app.properties", ignoreResourceNotFound = true)
}
)
public class AppConfig {

}
