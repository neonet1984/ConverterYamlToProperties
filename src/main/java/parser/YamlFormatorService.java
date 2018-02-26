package parser;

import java.util.List;

/**
 * The YamlFormatorService class is uses to convert yaml to properties
 */
public class YamlFormatorService implements YamlFormator {
    private static List<String> lines;

    /**
     * The method use to use to format yaml
     *
     * @return yamlLines formatted yaml List
     */
    public static List<String> getFormattedList(List<String> list) {
        lines = list;
        for (int indexLine = 0; indexLine < list.size(); indexLine++) {
            formatYamlList(indexLine);
        }
        return list;
    }

    private static void formatYamlList(int indexLine) {
        if (lines.get(indexLine).matches(".*>")) {
            String yamlLineOne = lines.get(indexLine);
            String yamlLineTwo = lines.get(indexLine + 1);
            yamlLineOne = yamlLineOne.replace(">", yamlLineTwo);
            lines.set(indexLine, yamlLineOne);
            lines.remove(indexLine + 1);
        }
    }


}
