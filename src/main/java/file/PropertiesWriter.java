package file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * The class is used to write the properties of a file
 */
public class PropertiesWriter implements IWriter<StringBuilder> {
    private static final Logger Log = LoggerFactory.getLogger(PropertiesWriter.class);
    private FileWriter writer;

    public PropertiesWriter(String path) {
        try {
            writer = new FileWriter(path, false);
        } catch (IOException e) {
            Log.error("Error opening file ", e);
        }
    }

    /**
     * The method writes the properties file
     *
     * @param propertiesLines
     */
    @Override
    public void write(List<StringBuilder> propertiesLines) {
        propertiesLines.forEach(
                prop -> {
                    try {
                        writer.write(prop.toString());
                        writer.append('\n').flush();
                    } catch (IOException e) {
                        Log.error("error writing to file ", e);
                    }
                });
    }
}
