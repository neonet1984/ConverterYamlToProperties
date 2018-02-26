package parser;

import model.Yaml;

import java.util.ArrayList;
import java.util.List;

/**
 * The Parser class is uses to convert yaml to properties
 */
public class Parser {
    private List<Yaml> yamlKeys = new ArrayList<>();
    private List<StringBuilder> propertiesList = new ArrayList<>();

    /**
     * The method overrides yaml in properties
     *
     * @param yamlList List contains yaml
     * @return Returns the converted properties
     */
    public List<StringBuilder> getConvertedPropertiesFromYaml(List<String> yamlList) {
        yamlList = YamlFormatorService.getFormattedYamlList(yamlList);
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
