package parser;

import model.*;

import java.util.ArrayList;
import java.util.List;


public class Parser extends AuxiliaryFuntionalParsing {
    private List<YamlModel> yamlListAttributes = new ArrayList<>();
    private List<StringBuilder> propertiesList = new ArrayList<>();

    public List<StringBuilder> yamlToProperties(List<String> yamlListConfiguration) {
        yamlListConfiguration.forEach(yamlStrConfig -> parsing(yamlStrConfig));
        return propertiesList;
    }

    private void parsing(String yamlStrConfig) {
        if (!checkYamlAttribute(yamlStrConfig)) {
            addYamlAttributes(yamlStrConfig);
        } else {
            setPropertiesStr(yamlStrConfig);
        }
    }

    private void addYamlAttributes(String yamlStrConfig) {
        int countSpace = getCountSpace(yamlStrConfig);
        clearConfiguration(countSpace);
        final String yamlAttribute = getYamlAttribute(yamlStrConfig);
        yamlListAttributes.add(new YamlModel(countSpace, yamlAttribute));
    }

    private void setPropertiesStr(String yamlConfiguration) {
        if (!addAtttribute(yamlConfiguration)) {
            StringBuilder propertiesConfig = new StringBuilder();
            int countSpace = getCountSpace(yamlConfiguration);
            clearConfiguration(countSpace);
            yamlListAttributes.stream()
                    .filter(item -> item.getCountSpace() < countSpace)
                    .forEach(item -> propertiesConfig.append(item.getYamlAttribute() + "."));
            propertiesConfig.append(getKeyValue(yamlConfiguration));
            propertiesList.add(propertiesConfig);
        }
    }

    private boolean addAtttribute(String yamlConfiguration) {
        final int sizePropertiesList = propertiesList.size() - 1;
        yamlConfiguration = yamlConfiguration.trim();
        if (sizePropertiesList > 0) {
            String propertiesStr = propertiesList.get(sizePropertiesList).toString();
            if (checkTransition(propertiesStr)) {
                final String str = propertiesList.get(sizePropertiesList).toString();
                final StringBuilder config = new StringBuilder(str.replace(">", yamlConfiguration));
                propertiesList.set(sizePropertiesList, config);
                return true;
            }
        }
        return false;
    }

    private void clearConfiguration(int countSpace) {
        yamlListAttributes.removeIf(item -> item.getCountSpace() >= countSpace);
    }

}
