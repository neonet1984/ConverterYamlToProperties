package com.parser;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The interface uses to bring the list to a convenient format for parsing
 */
@Service
public interface YamlFormator<T> {
    /**
     * The metod uses for molding in the required format
     *
     * @param list contains a list of lines for conversion
     * @return list<T> returns the converted list
     */
    List<T> getFormattedList(List<T> list);
}
