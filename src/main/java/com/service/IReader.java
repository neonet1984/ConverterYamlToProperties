package com.service;


import java.util.List;

/**
 * The interface is uses to read a com.file
 */

public interface IReader<T> {
    /**
     * The method read the  file
     *
     * @return List<T> read lines
     */
    List<T> read();

    /**
     * The method sets the path to the file
     */
    void setPath(String pathToFile);
}
