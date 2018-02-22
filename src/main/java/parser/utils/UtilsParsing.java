package parser.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilsParsing {

    public static boolean checkYamlAttribute(String yamlConfiguration) {
        yamlConfiguration = yamlConfiguration.trim();
        int countYamlAttribure = yamlConfiguration.split(":").length;
        if (countYamlAttribure > 1) {
            return true;
        } else {
            return false;
        }
    }

    public static int getCountSpace(String str) {
        int countSpace = 0;
        for (char symbol : str.toCharArray()) {
            if (symbol == ' ') {
                countSpace++;
            } else {
                return countSpace;
            }
        }
        return countSpace;
    }

    public static String getYamlAttribute(String yamlConfiguration) {
        return yamlConfiguration.replace(":", "").trim();
    }

    public static String getKeyValue(String yamlConfiguration) {
        yamlConfiguration = yamlConfiguration.replace(":", "=").
                replace(" ", "").replace("\"", "");
        return yamlConfiguration;
    }

    public static boolean checkTransition(String propertiesStr) {
        Pattern pattern = Pattern.compile(".*=>");
        Matcher matcher = pattern.matcher(propertiesStr);
        return matcher.matches();
    }

}
