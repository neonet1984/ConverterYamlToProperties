package com.service;


import java.util.List;

/**
 * The IParser is uses to convert from one format to another
 */
public interface IParser {
    /**
     * The method convert one format to another
     *
     * @param list contains a lines for conversion
     * @return returns the converted data
     */
    List<StringBuilder> getConverterData(List<String> list);
}
