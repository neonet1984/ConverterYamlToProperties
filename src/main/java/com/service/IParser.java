package com.service;


import java.util.List;

/**
 * The IParser  is uses to convert
 */
public interface IParser<T, O> {
    /**
     * The method overrides yaml in properties
     *
     * @param list contains a file for conversion
     * @return returns the converted data
     */
    List<T> getConverterData(List<O> list);
}
