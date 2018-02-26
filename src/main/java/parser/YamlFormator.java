package parser;

import java.util.List;

/**
 * The YamlFormator class is uses to convert yaml to properties
 */
public class YamlFormator {
    private static List<String> yamlLines;

    /**
     * The method use to use to format yaml
     *
     * @param yamlList contains  yaml lines
     * @return yamlLines formatted yaml List
     */
    public static List<String> getFormattedYamlList(List<String> yamlList) {
        yamlLines = yamlList;
        for (int index = 0; index < yamlLines.size(); index++) {
            formatYamlList(index);
        }
        return yamlLines;
    }

    private static void formatYamlList(int index) {
        if (yamlLines.get(index).matches(".*>")) {
            String yamlLineOne = yamlLines.get(index);
            String yamlLineTwo = yamlLines.get(index + 1);
            yamlLineOne = yamlLineOne.replace(">", yamlLineTwo);
            yamlLines.set(index, yamlLineOne);
            yamlLines.remove(index + 1);
        }
    }
}
