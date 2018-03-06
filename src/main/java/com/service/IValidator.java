package com.service;

import java.util.List;

/**
 * The IValidator interface is used to check the list lines, on correctness
 */
public interface IValidator {
    /**
     * The method is uses to check the list lines, on correctness
     *
     * @param values correctness list lines for check
     */
    void checkLines(List<String> values);
}
