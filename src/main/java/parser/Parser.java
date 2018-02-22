package parser;

import model.YamlModel;
import parser.utils.UtilsParsing;

import java.util.ArrayList;
import java.util.List;

/**
 * The Parser class is used to convert yaml to properties
 */
public class Parser {
    private List<YamlModel> yamlAttributes = new ArrayList<>();
    private List<StringBuilder> properties = new ArrayList<>();

    /**
     * The method overrides yaml in properties
     * @param yamlList List contains yaml
     * @return Returns the converted properties
     */
    public List<StringBuilder> yamlToProperties(List<String> yamlList) {
        yamlList.forEach(this::parsing);
        return properties;
    }

    private void parsing(String yamlLine) {
        if (!UtilsParsing.checkYamlAttribute(yamlLine)) {
            addYamlAttributes(yamlLine);
        } else {
            setPropertiesLine(yamlLine);
        }
    }

    private void addYamlAttributes(String yamlLine) {
        int countSpace = UtilsParsing.getCountSpace(yamlLine);
        clearYamlAttributes(countSpace);
        yamlAttributes.add(new YamlModel(countSpace, UtilsParsing.getYamlAttribute(yamlLine)));
    }

    private void setPropertiesLine(String yamlLine) {
        if (!checkProperties(yamlLine)) {
            StringBuilder propertiesLine = new StringBuilder();
            int countSpace = UtilsParsing.getCountSpace(yamlLine);
            clearYamlAttributes(countSpace);
            yamlAttributes.stream()
                    .filter(item -> item.getCountSpace() < countSpace)
                    .forEach(item -> propertiesLine.append(item.getYamlAttribute() + "."));
            propertiesLine.append(UtilsParsing.getKeyValue(yamlLine));
            properties.add(propertiesLine);
        }
    }

    private boolean checkProperties(String yamlLine) {
        int sizeProperties = properties.size() - 1;
        if (sizeProperties > 0) {
            String propertiesLine = properties.get(sizeProperties).toString();
            if (UtilsParsing.checkTransition(propertiesLine)) {
                propertiesLine = properties.get(sizeProperties).toString();
                properties.set(sizeProperties, new StringBuilder(propertiesLine.replace(">", yamlLine.trim())));
                return true;
            }
        }
        return false;
    }

    private void clearYamlAttributes(int countSpace) {
        yamlAttributes.removeIf(item -> item.getCountSpace() >= countSpace);
    }

}
