package com.service;


import java.util.List;

/**
 * The interface is uses to write a com.file
 */

public interface IWriter<T> {
    /**
     * The method writes the properties com.file
     *
     * @param values the input receives a list of rows for writing
     */
    void write(List<T> values);

    /**
     * The method sets the path to the file
     */
    void setPath(String pathToFile);
}
