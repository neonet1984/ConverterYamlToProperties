package com.service;

import java.util.List;

/**
 * The interface uses receive all the files in the transferred directory
 */
public interface IFile {
    /**
     * The method uses for get List containing file paths
     *
     * @param pathDirectory the directory from which you want to get the files
     * @return List containing file paths
     */
    List<String> getListPaths(String pathDirectory);

    /**
     * The method uses for delete file
     *
     * @param pathToFile the path to the file you want to delete
     */
    void moveFile(String pathToFile, String pathDirectory);
}
