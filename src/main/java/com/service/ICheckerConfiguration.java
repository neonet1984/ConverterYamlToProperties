package com.service;

/**
 * This interface checks the configuration in app.properties
 */
public interface ICheckerConfiguration {
    /**
     * This method checks whether the specified directories in app.properties
     */
    boolean isCheckPropertiesConfig();
}
