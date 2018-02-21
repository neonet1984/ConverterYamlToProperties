import file.ReadFile;
import file.WriteFile;
import parser.Parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Main {
    private static final String path = "src\\main\\resources\\app.properties";
    private static ReadFile readFile;
    private static WriteFile writeFile;
    private static Parser parser;

    private static void init() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(path));
        final String inputFile = properties.getProperty("input.file");
        final String outputFile = properties.getProperty("output.file");
        readFile = new ReadFile(inputFile);
        parser = new Parser();
        writeFile = new WriteFile(outputFile);
    }

    public static void main(String[] args) throws IOException {
        init();
        List<StringBuilder> propertiesList = parser.yamlToProperties(readFile.readYaml());
        writeFile.writeFile(propertiesList);
    }

}
