package com.service;


import com.exeprion.ValidatorException;

import java.util.List;

/**
 * The IValidator interface is used to check the list lines, on correctness
 */
public interface IValidator<T> {
    /**
     * The method is uses to check the list lines, on correctness
     */
    void checkLines(List<T> yamlLines) throws ValidatorException;
}
