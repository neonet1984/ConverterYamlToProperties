package com.file;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The interface is uses to read a com.file
 */
@Service
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
