package com.service.impl;

import com.model.Yaml;
import com.parser.UtilsParsing;
import com.service.IParser;

import com.service.IYamlFormator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * The ParserService class is uses to convert yaml to properties
 */
@Service
public class ParserService implements IParser {
    private static final Logger log = LoggerFactory.getLogger(ParserService.class);
    private final IYamlFormator yamlFormatorService;
    private List<Yaml> ymlKeys = new ArrayList<>();
    private List<StringBuilder> propertiesList = new ArrayList<>();

    @Autowired
    public ParserService(IYamlFormator yamlFormatorService) {
        this.yamlFormatorService = yamlFormatorService;
    }

    @Override
    public List<StringBuilder> getConverterData(List<String> ymlList) {
        propertiesList.clear();
        log.info("Start parser");
        ymlList = yamlFormatorService.getFormattedList(ymlList);
        ymlList.forEach(this::addToList);
        log.info("End parser");
        return propertiesList;
    }

    private void addToList(String line) {
        if (!UtilsParsing.checkYamlLine(line)) {
            addLineToYamlKeys(line);
        } else {
            addPropertiesList(line);
        }
    }

    private void addLineToYamlKeys(String line) {
        int countSpace = UtilsParsing.getCountSpace(line);
        deleteYamlKey(countSpace);
        ymlKeys.add(new Yaml(countSpace, UtilsParsing.getYamlKey(line)));
    }

    private void addPropertiesList(String line) {
        StringBuilder propertiesKeyValue = new StringBuilder();
        int countSpace = UtilsParsing.getCountSpace(line);
        deleteYamlKey(countSpace);
        ymlKeys.stream()
                .filter(getFilterByCountOfSpace(countSpace))
                .forEach(setPropertiesKeyValue(propertiesKeyValue));
        propertiesKeyValue.append(UtilsParsing.getKeyValue(line));
        propertiesList.add(propertiesKeyValue);
    }

    private void deleteYamlKey(int countSpace) {
        ymlKeys.removeIf(line -> line.getCountSpace() >= countSpace);
    }

    private Predicate<? super Yaml> getFilterByCountOfSpace(int countSpace) {
        return key -> key.getCountSpace() < countSpace;
    }

    private Consumer<? super Yaml> setPropertiesKeyValue(StringBuilder propertiesKeyValue) {
        return key -> propertiesKeyValue.append(key.getYamlKey()).append(".");
    }
}
