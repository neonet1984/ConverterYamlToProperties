package parser;


import java.util.List;

public class YamlFormator {

    public static List<String> getFormattedYamlList(List<String> yamlLines) {
        for (int index = 0; index < yamlLines.size(); index++) {
            if (yamlLines.get(index).matches(".*>")) {
                String yamlLine1 = yamlLines.get(index);
                String yamlLine2 = yamlLines.get(index + 1);
                yamlLine1 = yamlLine1.replace(">", yamlLine2);
                yamlLines.set(index, yamlLine1);
                yamlLines.remove(index + 1);
            }
        }
        return yamlLines;
    }
}
