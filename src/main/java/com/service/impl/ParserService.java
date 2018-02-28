package com.service.impl;

import com.model.Yaml;
import com.parser.UtilsParsing;
import com.service.IParser;
import com.service.IValidator;
import com.service.IYamlFormator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The IParserService class is uses to convert yaml to properties
 */
@Service
public class ParserService implements IParser<StringBuilder, String> {
    private final IYamlFormator IYamlFormator;
    private final IValidator IValidator;
    private List<Yaml> yamlKeys = new ArrayList<>();
    private List<StringBuilder> propertiesList = new ArrayList<>();

    @Autowired
    public ParserService(IYamlFormator IYamlFormator, IValidator IValidator) {
        this.IYamlFormator = IYamlFormator;
        this.IValidator = IValidator;
    }

    @Override
    public List<StringBuilder> getConverterData(List<String> yamlList) {
        yamlList = IYamlFormator.getFormattedList(yamlList);
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
        deleteYamlKey(countSpace);
        yamlKeys.add(new Yaml(countSpace, UtilsParsing.getYamlKey(line)));
    }

    private void addPropertiesList(String line) {
        StringBuilder propertiesKeyValue = new StringBuilder();
        int countSpace = UtilsParsing.getCountSpace(line);
        deleteYamlKey(countSpace);
        yamlKeys.stream()
                .filter(yaml -> yaml.getCountSpace() < countSpace)
                .forEach(yaml -> propertiesKeyValue.append(yaml.getYamlKey()).append("."));
        propertiesKeyValue.append(UtilsParsing.getKeyValue(line));
        propertiesList.add(propertiesKeyValue);
    }

    private void deleteYamlKey(int countSpace) {
        yamlKeys.removeIf(line -> line.getCountSpace() >= countSpace);
    }


}
