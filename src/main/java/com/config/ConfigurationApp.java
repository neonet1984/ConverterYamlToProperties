package com.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com")
@PropertySource("app.properties")
public class ConfigurationApp {
    private static final Logger log = LoggerFactory.getLogger(ConfigurationApp.class);

}
