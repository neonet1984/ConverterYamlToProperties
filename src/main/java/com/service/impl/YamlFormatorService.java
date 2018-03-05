package com.service.impl;

import com.service.IYamlFormator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * The class to convert to a convenient form of yamlLines, for further parsing
 */
@Service
public class YamlFormatorService implements IYamlFormator {
    private static final Logger log = LoggerFactory.getLogger(YamlFormatorService.class);

    /**
     * The method use to format yaml
     *
     * @return yamlLines formatted yaml List
     */
    public List<String> getFormattedList(List<String> list) {
        log.info("List forming");
        for (int indexLine = 0; indexLine < list.size(); indexLine++) {
            list = formatYamlList(indexLine, list);
        }
        return list;
    }

    private List<String> formatYamlList(int indexLine, List<String> listLines) {
        if (listLines.get(indexLine).matches(".*>")) {
            String yamlLineOne = listLines.get(indexLine);
            String yamlLineTwo = listLines.get(indexLine + 1);
            yamlLineOne = yamlLineOne.replace(">", yamlLineTwo);
            listLines.set(indexLine, yamlLineOne);
            listLines.remove(indexLine + 1);
        }
        return listLines;
    }

    public static void main(String[] args) {
        List list = new LinkedList<String>();
        Map<String,String> n = new HashMap<>();
        n.put("test","test");
        n.put("test3","test");
        System.out.println(n.keySet());
    }
}
