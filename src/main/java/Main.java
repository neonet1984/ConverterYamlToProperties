import file.ReadFile;
import file.WriteFile;
import parser.Parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Main {
    private static final String path = "src\\main\\resources\\app.properties";
    private static Properties properties;
    private static ReadFile readFile;
    private static WriteFile writeFile;
    private static Parser parser;

    private static void init() {
        properties = new Properties();
        readFile = new ReadFile();
        parser = new Parser();
        writeFile = new WriteFile();
    }

    public static void main(String[] args) throws IOException {
        init();
        properties.load(new FileInputStream(path));
        String intupFile = properties.getProperty("input.file");
        String outputFile = properties.getProperty("output.file");
        List yamlFile = readFile.readYaml(intupFile);
        List<StringBuilder> propertiesList = parser.yamlToProperties(yamlFile);
        writeFile.writeFile(propertiesList, outputFile);
    }

}
