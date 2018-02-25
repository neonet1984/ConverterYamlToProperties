package parser;

import Exeption.ValidatorExeption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * The YamlValidator class is used to check the yaml lines, on correctness
 */
public class YamlValidator {
    private static final Logger Log = LoggerFactory.getLogger(YamlValidator.class);

    /**
     * the method checks for the correctness of the yaml string,
     * in case the file is not valid throw an ValidatorExeption
     *
     * @param yamlLines List contains yaml
     */
    public static void checkYamlLines(List<String> yamlLines) {
        try {
            if (!verificationYamlList(yamlLines))
                throw new ValidatorExeption();
        } catch (ValidatorExeption e) {
            Log.error("Not a valid file", e);
        }
    }

    private static boolean verificationYamlList(List<String> yamlLines) {
        return yamlLines.stream().filter(yamlLine ->
                UtilsParsing.getCountSpace(yamlLine) % 4 != 0
        ).count() == 0;
    }
}
