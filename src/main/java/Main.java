import file.ReadFile;
import file.WriteFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import parser.Parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    private static final String PATH = "app.properties";
    private static ReadFile readFile;
    private static WriteFile writeFile;
    private static Parser parser = new Parser();

    private static void init() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PATH));
        } catch (IOException e) {
            LOG.error("Can not read configuration file ", e);
        }
        final String inputFile = properties.getProperty("input.file");
        final String outputFile = properties.getProperty("output.file");
        readFile = new ReadFile(inputFile);
        writeFile = new WriteFile(outputFile);
    }

    public static void main(String[] args) throws IOException {
        init();
        LOG.info("Start parsing");
        long start = System.currentTimeMillis();
        List<StringBuilder> propertiesList = parser.yamlToProperties(readFile.readYaml());
        writeFile.writeFile(propertiesList);
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        LOG.info("End parsing");
        LOG.info("Execution time of the program: " + timeConsumedMillis + " ms");
    }

}
