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
        yamlList = YamlFormator.getFormattedYamlList(yamlList);
        yamlList.forEach(this::addToList);
        return propertiesList;
    }

    private void addToList(String yamlLine) {
        if (!UtilsParsing.checkYamlLine(yamlLine)) {
            addYamlLineToYamlListKeys(yamlLine);
        } else {
            addPropertiesList(yamlLine);
        }
    }

    private void addYamlLineToYamlListKeys(String yamlLine) {
        int countSpace = UtilsParsing.getCountSpace(yamlLine);
        deleateYamlKey(countSpace);
        yamlKeys.add(new Yaml(countSpace, UtilsParsing.getYamlKey(yamlLine)));
    }

    private void addPropertiesList(String yamlLine) {
        StringBuilder propertiesKeyValue = new StringBuilder();
        int countSpace = UtilsParsing.getCountSpace(yamlLine);
        deleateYamlKey(countSpace);
        yamlKeys.stream()
                .filter(yaml -> yaml.getCountSpace() < countSpace)
                .forEach(yaml -> propertiesKeyValue.append(yaml.getYamlKey() + "."));
        propertiesKeyValue.append(UtilsParsing.getKeyValue(yamlLine));
        propertiesList.add(propertiesKeyValue);
    }

    private void deleateYamlKey(int countSpace) {
        yamlKeys.removeIf(yamlKey -> yamlKey.getCountSpace() >= countSpace);
    }

}
