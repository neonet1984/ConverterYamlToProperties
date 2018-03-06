package com.model;

/**
 * The class is used to store yaml attributes and the
 * number of spaces at the beginning of the yaml line
 */
public class Yaml {
    private int countSpace;
    private String yamlKey;

    public Yaml(int countSpace, String yamlKey) {
        this.countSpace = countSpace;
        this.yamlKey = yamlKey;
    }

    public int getCountSpace() {
        return countSpace;
    }

    public void setCountSpace(int countSpace) {
        this.countSpace = countSpace;
    }

    public String getYamlKey() {
        return yamlKey;
    }

    public void setYamlKey(String yamlKey) {
        this.yamlKey = yamlKey;
    }
}
