package com.parser;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The Validator interface is used to check the list lines, on correctness
 */
@Service
public interface Validator<T> {
    /**
     * The method is uses to check the list lines, on correctness
     */
    void checkLines(List<T> yamlLines);
}
