package com.service.impl;

import com.model.Yaml;
import com.parser.UtilsParsing;
import com.service.IParser;
import com.service.IValidator;
import com.service.IYamlFormator;
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
public class ParserService implements IParser {
    private static final Logger log = LoggerFactory.getLogger(ParserService.class);
    private final IYamlFormator yamlFormator;
    private final IValidator yamlValidator;
    private List<Yaml> yamlKeys = new ArrayList<>();
    private List<StringBuilder> propertiesList = new ArrayList<>();

    @Autowired
    public ParserService(IYamlFormator yamlFormator, IValidator yamlValidator) {
        this.yamlFormator = yamlFormator;
        this.yamlValidator = yamlValidator;
    }

    @Override
    public List<StringBuilder> getConverterData(List<String> yamlList) {
        log.info("Start parser");
        yamlList = yamlFormator.getFormattedList(yamlList);
        yamlList.forEach(this::addToList);
        log.info("End parser");
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
                .filter(key -> key.getCountSpace() < countSpace)
                .forEach(key -> propertiesKeyValue.append(key.getYamlKey()).append("."));
        propertiesKeyValue.append(UtilsParsing.getKeyValue(line));
        propertiesList.add(propertiesKeyValue);
    }

    private void deleteYamlKey(int countSpace) {
        yamlKeys.removeIf(line -> line.getCountSpace() >= countSpace);
    }
}
