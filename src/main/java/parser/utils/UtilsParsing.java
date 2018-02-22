package parser.utils;

import static java.util.regex.Pattern.compile;

public class UtilsParsing {

    public static boolean checkYamlAttribute(String yamlConfiguration) {
        int countYamlAttribure = yamlConfiguration.trim().split(":").length;
        return (countYamlAttribure > 1);
    }

    public static int getCountSpace(String str) {
        int countSpace = 0;
        for (char symbol : str.toCharArray()) {
            if (symbol != ' ') {
                return countSpace;
            }
            countSpace++;
        }
        return countSpace;
    }

    public static String getYamlAttribute(String yamlLine) {
        return yamlLine.replace(":", "").trim();
    }

    public static String getKeyValue(String yamlLine) {
        return yamlLine.replace(":", "=").
                replace(" ", "").replace("\"", "");
    }

    public static boolean checkTransition(String propertiesLine) {
        return compile(".*=>").matcher(propertiesLine).matches();
    }

}
