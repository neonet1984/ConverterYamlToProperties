package parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Predicate;

/**
 * The YamlValidatorService class is used to check the yaml lines, on correctness
 */
public class YamlValidatorService {
    private static final Logger log = LoggerFactory.getLogger(YamlValidatorService.class);

    /**
     * the method checks for the correctness of the yaml string,
     * in case the file is not valid throw an ValidatorException
     *
     * @param yamlLines List contains yaml
     */
    public static void checkLines(List<String> yamlLines) {
        if (!isVerificationYamlList(yamlLines))
            log.error("Not a valid file");
    }

    private static boolean isVerificationYamlList(List<String> yamlLines) {
        Predicate<String> predicateForFilter = yamlLine -> UtilsParsing.getCountSpace(yamlLine) % 4 != 0;
        return yamlLines.stream()
                .filter(predicateForFilter)
                .count() == 0;
    }
}
