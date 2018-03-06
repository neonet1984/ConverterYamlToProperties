package com.service;

import java.util.List;

/**
 * The interface is uses for reading and writing files
 */
public interface IFileAdapter {
    /**
     * The method is used to initialize fields
     */
    void init();

    /**
     * The method is uses to read file
     *
     * @return List lines
     */
    List<String> readFile();

    /**
     * The method is uses to write file
     * @param values List contains a lines for writing
     */
    void write(List<StringBuilder> values);
}
