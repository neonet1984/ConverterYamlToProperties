package parser;

import Exeption.ValidatorExeption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Predicate;

/**
 * The YamlValidator class is used to check the yaml lines, on correctness
 */
public class YamlValidator {
    private static final Logger log = LoggerFactory.getLogger(YamlValidator.class);

    /**
     * the method checks for the correctness of the yaml string,
     * in case the file is not valid throw an ValidatorExeption
     *
     * @param yamlLines List contains yaml
     */
    public static void checkYamlLines(List<String> yamlLines) {
        try {
            if (!isVerificationYamlList(yamlLines))
                throw new ValidatorExeption();
        } catch (ValidatorExeption e) {
            log.error("Not a valid file", e);
        }
    }

    private static boolean isVerificationYamlList(List<String> yamlLines) {
        Predicate<String> predicateForFilter = yamlLine -> UtilsParsing.getCountSpace(yamlLine) % 4 != 0;
        return yamlLines.stream()
                .filter(predicateForFilter)
                .count() == 0;
    }
}
