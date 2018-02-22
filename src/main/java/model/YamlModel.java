package model;

/**
 * The class is used to store yaml attributes and the
 * number of spaces at the beginning of the yaml line
 */
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
