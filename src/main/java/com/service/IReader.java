package com.service;


import java.util.List;

/**
 * The interface is uses to read a file
 */
public interface IReader {
    /**
     * The method read the file
     *
     * @return List<String> read lines
     */
    List<String> read();

    /**
     * The method sets the path to the file
     */
    void setPath(String pathToFile);
}
