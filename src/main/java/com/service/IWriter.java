package com.service;


import java.util.List;

/**
 * The interface is uses to write a file
 */
public interface IWriter {
    /**
     * The method writes the properties file
     *
     * @param values the input receives a list of rows for writing
     */
    void write(List<StringBuilder> values);

    /**
     * The method sets the path to the file
     */
    void setPath(String pathToFile);
}
