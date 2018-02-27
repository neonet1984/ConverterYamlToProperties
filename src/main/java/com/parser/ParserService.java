package com.parser;

import com.model.Yaml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The ParserService class is uses to convert yaml to properties
 */
@Service
public class ParserService implements Parser<StringBuilder, String> {
    @Autowired
    private YamlFormator yamlFormator;
    private List<Yaml> yamlKeys = new ArrayList<>();
    private List<StringBuilder> propertiesList = new ArrayList<>();
    
    @Override
    public List<StringBuilder> getConverterData(List<String> yamlList) {
        yamlList = yamlFormator.getFormattedList(yamlList);
        yamlList.forEach(this::addToList);
        return propertiesList;
    }

    private void addToList(String line) {
        if (!UtilsParsing.checkYamlLine(line)) {
            addYamlLineToYamlListKeys(line);
        } else {
            addPropertiesList(line);
        }
    }

    private void addYamlLineToYamlListKeys(String line) {
        int countSpace = UtilsParsing.getCountSpace(line);
        deleateYamlKey(countSpace);
        yamlKeys.add(new Yaml(countSpace, UtilsParsing.getYamlKey(line)));
    }

    private void addPropertiesList(String line) {
        StringBuilder propertiesKeyValue = new StringBuilder();
        int countSpace = UtilsParsing.getCountSpace(line);
        deleateYamlKey(countSpace);
        yamlKeys.stream()
                .filter(yaml -> yaml.getCountSpace() < countSpace)
                .forEach(yaml -> propertiesKeyValue.append(yaml.getYamlKey() + "."));
        propertiesKeyValue.append(UtilsParsing.getKeyValue(line));
        propertiesList.add(propertiesKeyValue);
    }

    private void deleateYamlKey(int countSpace) {
        yamlKeys.removeIf(line -> line.getCountSpace() >= countSpace);
    }


}
