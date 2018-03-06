package com.service;

import java.util.List;

/**
 * The interface is uses for reading and writing files
 */
public interface IFileAdapter {
    /**
     * The method is uses to read file
     *
     * @return List lines
     */
    List readFile(String path);

    /**
     * The method is uses to write file
     *
     * @param values List contains a lines for writing
     */
    void write(List<StringBuilder> values);

    /**
     * The method uses to delete files
     *
     * @param path path to the file you want to delete
     */
    void removeFile(String path);

    /**
     * The method is used to get the file paths from the directory
     * along the path specified in app.properties
     */
    List<String> getListPaths();
}
