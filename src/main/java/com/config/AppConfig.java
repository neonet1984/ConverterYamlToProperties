package com.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Configuration searches for the service and loads app.properties
 */
@Configuration
@ComponentScan("com.service")
@PropertySource("app.properties")
@EnableScheduling
public class AppConfig {

}
