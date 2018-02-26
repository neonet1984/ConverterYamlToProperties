import file.IReader;
import file.IWriter;
import file.PropertiesWriter;
import file.YamlReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import parser.Parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * The Main class is uses as an entry point to the program
 */
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final String PATH = "app.properties";
    private static IReader yamlReader;
    private static IWriter propertiesWriter;

    private static void init() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PATH));
        } catch (IOException e) {
            log.error("Can not yamlReader configuration file ", e);
        }
        final String inputFile = properties.getProperty("input.file");
        final String outputFile = properties.getProperty("output.file");
        yamlReader = new YamlReader(inputFile);
        propertiesWriter = new PropertiesWriter(outputFile);
    }

    /**
     * The Main class is uses as an entry point to the program
     */
    public static void main(String[] args) {
        init();
        log.info("Start parsing");
        long start = System.currentTimeMillis();
        List<StringBuilder> propertiesLines = new Parser().getConvertedPropertiesFromYaml(yamlReader.read());
        propertiesWriter.write(propertiesLines);
        log.info("End parsing");
        log.info("Execution time of the program: " + (System.currentTimeMillis() - start) + " ms");
    }

}
