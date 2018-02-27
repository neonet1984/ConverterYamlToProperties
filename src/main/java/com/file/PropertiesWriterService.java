package com.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * The class is uses to write properties a file
 */
@Service
public class PropertiesWriterService implements IWriter<StringBuilder> {
    private static final Logger log = LoggerFactory.getLogger(PropertiesWriterService.class);
    private FileWriter fileWriter;

    @Override
    public void write(List<StringBuilder> propertiesLines) {
        propertiesLines.forEach(prop -> {
            try {
                fileWriter.write(prop.toString());
                fileWriter.append('\n').flush();
            } catch (IOException e) {
                log.error("Error writing to file ", e);
            }
        });
    }

    @Override
    public void setPath(String pathToFile) {
        openFile(pathToFile);
    }

    private void openFile(String pathToFile) {
        try {
            fileWriter = new FileWriter(pathToFile, false);
        } catch (IOException e) {
            log.error("Error opening file ", e);
        }
    }
}
