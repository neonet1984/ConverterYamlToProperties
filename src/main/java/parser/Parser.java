package parser;

import model.*;
import parser.utils.UtilsParsing;
import java.util.ArrayList;
import java.util.List;


public class Parser {
    private List<YamlModel> yamlAttributes = new ArrayList<>();
    private List<StringBuilder> convertProperties = new ArrayList<>();

    public List<StringBuilder> yamlToProperties(List<String> yamlList) {
        yamlList.forEach(yamlStr -> parsing(yamlStr));
        return convertProperties;
    }

    private void parsing(String yamlStr) {
        if (!UtilsParsing.checkYamlAttribute(yamlStr)) {
            addYamlAttributes(yamlStr);
        } else {
            setPropertiesStr(yamlStr);
        }
    }

    private void addYamlAttributes(String yamlStr) {
        int countSpace = UtilsParsing.getCountSpace(yamlStr);
        clearYamlAttributes(countSpace);
        final String yamlAttribute = UtilsParsing.getYamlAttribute(yamlStr);
        yamlAttributes.add(new YamlModel(countSpace, yamlAttribute));
    }

    private void setPropertiesStr(String yamlAttribure) {
        if (!addAtttribute(yamlAttribure)) {
            StringBuilder propertiesConfig = new StringBuilder();
            int countSpace = UtilsParsing.getCountSpace(yamlAttribure);
            clearYamlAttributes(countSpace);
            yamlAttributes.stream()
                    .filter(item -> item.getCountSpace() < countSpace)
                    .forEach(item -> propertiesConfig.append(item.getYamlAttribute() + "."));
            propertiesConfig.append(UtilsParsing.getKeyValue(yamlAttribure));
            convertProperties.add(propertiesConfig);
        }
    }

    private boolean addAtttribute(String yamlConfiguration) {
        final int sizePropertiesList = convertProperties.size() - 1;
        yamlConfiguration = yamlConfiguration.trim();
        if (sizePropertiesList > 0) {
            String propertiesStr = convertProperties.get(sizePropertiesList).toString();
            if (UtilsParsing.checkTransition(propertiesStr)) {
                final String str = convertProperties.get(sizePropertiesList).toString();
                final StringBuilder config = new StringBuilder(str.replace(">", yamlConfiguration));
                convertProperties.set(sizePropertiesList, config);
                return true;
            }
        }
        return false;
    }

    private void clearYamlAttributes(int countSpace) {
        yamlAttributes.removeIf(item -> item.getCountSpace() >= countSpace);
    }

}
