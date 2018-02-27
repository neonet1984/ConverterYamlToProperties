package com.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


@Configuration
@ComponentScan("com")
public class ConfigurationApp {
    private static final Logger log = LoggerFactory.getLogger(ConfigurationApp.class);
    @Bean
    public Properties properties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("app.properties"));
        } catch (IOException e) {
            log.error("Can not properties file ", e);
        }
        return properties;
    }

}
