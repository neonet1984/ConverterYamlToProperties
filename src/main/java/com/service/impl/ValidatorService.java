package com.service.impl;

import com.parser.UtilsParsing;
import com.service.IValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

/**
 * The YamlValidatorService class is uses to check the yaml lines, on correctness
 */
@Service
public class ValidatorService implements IValidator {
    private static final Logger log = LoggerFactory.getLogger(ValidatorService.class);

    /**
     * The method checks for the correctness of the yaml string,
     * in case the file is not valid throw an ValidatorException
     *
     * @param yamlLines List contains yaml
     */
    @Override
    public void checkLines(List<String> yamlLines) {
        if (!isValidYamlList(yamlLines)) {
            log.error("Is not valid yaml");
        }
    }

    private boolean isValidYamlList(List<String> values) {
        Predicate<String> expectedCountSpace = line -> UtilsParsing.getCountSpace(line) % 4 != 0;
        return values.stream()
                .noneMatch(expectedCountSpace);

    }

}
