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
    List readFile(String pathToFile);

    /**
     * The method is uses to write file
     *
     * @param values List contains a lines for writing
     */
    void write(List<StringBuilder> values);

    /**
     * This method is used to move files from one directory to another
     *
     * @param pathToFile    contains the path to the file that you want to move
     * @param pathDirectory contains the path to the directory where you want to put the file
     */
    void moveFile(String pathToFile, String pathDirectory);

    /**
     * The method is used to get the file paths from the directory
     * along the path specified in app.properties
     */
    List<String> getListPaths();

    /**
     * This method is used to move a file to a directory with non-valid files
     */
    void moveFileToDirectoryNotValidFiles(String pathToFile);

    /**
     * This method is used to move a file to a directory with converted files
     */
    void moveFileToDirectoryWithConvertedFiles(String pathToFile);
}
