package model;

public class YamlModel {
    private int countSpace;
    private String yamlAttribute;

    public YamlModel(int countSpace, String yamlAttribute) {
        this.countSpace = countSpace;
        this.yamlAttribute = yamlAttribute;
    }

    public int getCountSpace() {
        return countSpace;
    }

    public void setCountSpace(int countSpace) {
        this.countSpace = countSpace;
    }

    public String getYamlAttribute() {
        return yamlAttribute;
    }

    public void setYamlAttribute(String yamlAttribute) {
        this.yamlAttribute = yamlAttribute;
    }
}
