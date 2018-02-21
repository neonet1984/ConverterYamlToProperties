package parser;

import model.YamlModel;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private List<YamlModel> yamlListAttributes;
    private List<StringBuilder> propertiesList;

    public Parser() {
        propertiesList = new ArrayList<>();
        yamlListAttributes = new ArrayList<>();
    }

    public List<StringBuilder> yamlToProperties(List<String> yamlListConfiguration) {
        for (String yamlConfiguration : yamlListConfiguration) {
            if (!checkYamlAttribute(yamlConfiguration)) {
                addYamlAttributes(yamlConfiguration);
            } else {
                setPropertiesList(yamlConfiguration);
            }
        }
        return propertiesList;
    }

    private void addYamlAttributes(String yamlConfiguration) {
        int countSpace = getCountSpace(yamlConfiguration);
        clearConfiguration(countSpace);
        final String yamlAttribute = getYamlAttribute(yamlConfiguration);
        yamlListAttributes.add(new YamlModel(countSpace, yamlAttribute));
    }

    private void setPropertiesList(String yamlConfiguration) {
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
        final int size = propertiesList.size() - 1;
        yamlConfiguration = yamlConfiguration.trim();
        final char[] mas;
        if (size > 0) {
            mas = propertiesList.get(size).toString().toCharArray();
            if (mas.length > 0 && mas[mas.length - 1] == '>') {
                final String str = propertiesList.get(size).toString();
                final StringBuilder config = new StringBuilder(str.replace(">", yamlConfiguration));
                propertiesList.set(size, config);
                return true;
            }
        }
        return false;
    }

    private boolean checkYamlAttribute(String yamlConfiguration) {
        int countYamlAttribure = yamlConfiguration.split(":").length;
        if (countYamlAttribure > 1)
            return true;
        else return false;
    }

    private String getYamlAttribute(String yamlConfiguration) {
        return yamlConfiguration.replace(":", "").trim();
    }

    private String getKeyValue(String yamlConfiguration) {
        yamlConfiguration = yamlConfiguration.replace(":", "=").
                replace(" ", "").replace("\"", "");
        return yamlConfiguration;
    }

    private int getCountSpace(String str) {
        int countSpace = 0;
        for (char symbol : str.toCharArray()) {
            if (symbol == ' ') countSpace++;
            else return countSpace;
        }
        return countSpace;
    }

    private void clearConfiguration(int countSpace) {
        yamlListAttributes.removeIf(item -> item.getCountSpace() >= countSpace);
    }

}
