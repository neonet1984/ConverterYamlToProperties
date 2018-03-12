package com.service.impl;

import com.parser.UtilsParsing;
import com.service.IValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * The YamlValidatorService class is uses to check the yaml lines, on correctness
 */
@Service
public class ValidatorService implements IValidator {
    private static final Logger log = LoggerFactory.getLogger(ValidatorService.class);

    @Override
    public boolean checkLines(List<String> yamlLines) {
        if (!isValidYamlList(yamlLines)) {
            log.error("Is not valid yaml\nNon-valid lines:");
            printlnLinesNotValidYaml(yamlLines);
            return false;
        }
        return true;
    }

    private boolean isValidYamlList(List<String> values) {
        return values.stream()
                .noneMatch(getExpectedCountSpace());
    }

    private void printlnLinesNotValidYaml(List<String> values) {
        IntStream.range(0, values.size())
                .filter(i -> getExpectedCountSpace(values.get(i)))
                .forEach(i -> log.error(i + 1 + " line, value: \"" + values.get(i).trim() + "\""));
    }

    private Predicate<? super String> getExpectedCountSpace() {
        return line -> UtilsParsing.getCountSpace(line) % 4 != 0;
    }

    private boolean getExpectedCountSpace(String line) {
        return UtilsParsing.getCountSpace(line) % 4 != 0;
    }
}
