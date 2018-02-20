package file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {
    private static final Logger LOG = LoggerFactory.getLogger(WriteFile.class);

    public void writeFile(List<StringBuilder> prop, String path) {
        try (FileWriter writer = new FileWriter(path, false)) {
            for (StringBuilder propertiesConfiguration : prop) {
                writer.write(propertiesConfiguration.toString());
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }
}

