package parser.utils;

import static java.util.regex.Pattern.compile;

/**
 * Utils class for Prarser class
 */
public class UtilsParsing {

    /**
     * The method checks the number of attributes in the yaml line
     *
     * @param yamlLine
     */
    public static boolean checkYamlAttribute(String yamlLine) {
        int countYamlAttribure = yamlLine.trim().split(":").length;
        return (countYamlAttribure > 1);
    }

    /**
     * The method is used to calculate the number of spaces
     * in at the beginning of the yaml line
     *
     * @param yamlLine
     * @return number of spaces
     */
    public static int getCountSpace(String yamlLine) {
        int countSpace = 0;
        for (char symbol : yamlLine.toCharArray()) {
            if (symbol != ' ') {
                return countSpace;
            }
            countSpace++;
        }
        return countSpace;
    }

    /**
     * The method is used to get the yaml attribute
     *
     * @param yamlLine
     * @return yaml attribute
     */
    public static String getYamlAttribute(String yamlLine) {

        return yamlLine.replace(":", "").trim();
    }

    /**
     * The method is used to get key: value from yaml line
     *
     * @param yamlLine
     * @return format value: "key: value"
     */
    public static String getKeyValue(String yamlLine) {
        return yamlLine.replace(":", "=").
                replace(" ", "").replace("\"", "");
    }

    /**
     * The method from the properties line checks for the presence of the ">"
     *
     * @param propertiesLine
     */
    public static boolean checkTransition(String propertiesLine) {
        return compile(".*=>").matcher(propertiesLine).matches();
    }

}
