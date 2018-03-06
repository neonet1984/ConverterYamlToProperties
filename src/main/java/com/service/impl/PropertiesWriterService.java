package com.service.impl;

import com.service.IWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * This class is uses to write lines to a format .properties
 */
@Service
public class PropertiesWriterService implements IWriter{
    private static final Logger log = LoggerFactory.getLogger(PropertiesWriterService.class);
    private FileWriter fileWriter;

    @Override
    public void write(List<StringBuilder> propertiesLines) {
        log.info("Write down a .properties file");
        propertiesLines.forEach(prop -> {
            try {
                fileWriter.write(prop.toString());
                fileWriter.append('\n').flush();
            } catch (IOException e) {
                log.error("Error writing to file ", e);
            }
        });
        closeFile();
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

    private void closeFile() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            log.error("Error closing file", e.getMessage());
        }
    }
}
