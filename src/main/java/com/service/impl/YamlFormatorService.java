package com.service.impl;

import com.service.IYamlFormator;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The class to convert to a convenient form of yamlLines, for further parsing
 */
@Service
public class YamlFormatorService implements IYamlFormator {
    private List<String> lines;

    /**
     * The method use to format yaml
     *
     * @return yamlLines formatted yaml List
     */
    public List<String> getFormattedList(List<String> list) {
        lines = list;
        for (int indexLine = 0; indexLine < list.size(); indexLine++) {
            formatYamlList(indexLine);
        }
        return lines;
    }

    private void formatYamlList(int indexLine) {
        if (lines.get(indexLine).matches(".*>")) {
            String yamlLineOne = lines.get(indexLine);
            String yamlLineTwo = lines.get(indexLine + 1);
            yamlLineOne = yamlLineOne.replace(">", yamlLineTwo);
            lines.set(indexLine, yamlLineOne);
            lines.remove(indexLine + 1);
        }
    }

}
