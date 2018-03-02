package com.service;


import java.util.List;

/**
 * The interface uses to bring the list to a convenient format for parsing
 */
public interface IYamlFormator {
    /**
     * The metod uses for molding in the required format
     *
     * @param list contains a list of lines for conversion
     * @return returns the converted list
     */
    List<String> getFormattedList(List<String> list);
}
