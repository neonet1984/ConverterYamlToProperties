package parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuxiliaryFuntionalParsing {

    protected boolean checkYamlAttribute(String yamlConfiguration) {
        yamlConfiguration=yamlConfiguration.trim();
        int countYamlAttribure = yamlConfiguration.split(":").length;
        if (countYamlAttribure > 1)
            return true;
        else return false;
    }

    protected int getCountSpace(String str) {
        int countSpace = 0;
        for (char symbol : str.toCharArray()) {
            if (symbol == ' ') countSpace++;
            else return countSpace;
        }
        return countSpace;
    }

    protected String getYamlAttribute(String yamlConfiguration) {
        return yamlConfiguration.replace(":", "").trim();
    }

    protected String getKeyValue(String yamlConfiguration) {
        yamlConfiguration = yamlConfiguration.replace(":", "=").
                replace(" ", "").replace("\"", "");
        return yamlConfiguration;
    }

    protected boolean checkTransition(String propertiesStr) {
        Pattern pattern = Pattern.compile(".*=>");
        Matcher matcher = pattern.matcher(propertiesStr);
        return matcher.matches();
    }

}
