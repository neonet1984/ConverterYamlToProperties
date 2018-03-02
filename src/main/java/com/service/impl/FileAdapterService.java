package com.service.impl;

import com.service.IFileAdapter;
import com.service.IReader;
import com.service.IWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The class encapsulates the service for reading and the service for writing files
 */
@Service
public class FileAdapterService implements IFileAdapter {
    private static final Logger log = LoggerFactory.getLogger(FileAdapterService.class);

    private final IReader yamlReader;

    private final IWriter yamlWrite;

    @Value("${input.file:inputFile.txt}")
    private String inputFile;

    @Value("${output.file:output.txt}")
    private String outputFile;

    /**
     * The constructor initializes the value fields, for the initialization
     * it receives from app.properties
     *
     * @param yamlReader Service for reader yaml
     * @param yamlWrite  Service for write properties
     */
    @Autowired
    public FileAdapterService(IReader yamlReader, IWriter yamlWrite) {
        this.yamlReader = yamlReader;
        this.yamlWrite = yamlWrite;
    }

    @Override
    public void init() {
        log.info("initialization");
        yamlReader.setPath(inputFile);
        yamlWrite.setPath(outputFile);
    }

    @Override
    public List<String> readFile() {
        return yamlReader.read();
    }

    @Override
    public void write(List<StringBuilder> values) {
        yamlWrite.write(values);
    }
}
