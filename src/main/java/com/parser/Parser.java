package com.parser;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The Parser  is uses to convert
 */
@Service
public interface Parser<T, O> {
    /**
     * The method overrides yaml in properties
     *
     * @param list contains a file for conversion
     * @return returns the converted data
     */
    List<T> getConverterData(List<O> list);
}
