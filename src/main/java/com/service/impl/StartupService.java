package com.service.impl;

import com.service.IParser;
import com.service.IReader;
import com.service.IStartup;
import com.service.IWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * The class encapsulates read file,parsing file and write file
 */
@Service
public class StartupService implements IStartup {
    private static final Logger log = LoggerFactory.getLogger(StartupService.class);

    private final IParser IParser;

    private final IReader yamlReader;

    private final IWriter yamlWrite;

    @Value("${input.file:inputFile.txt}")
    private String inputFile;

    @Value("${output.file:output.txt}")
    private String outputFile;

    @Autowired
    public StartupService(IParser IParser, IReader yamlReader, IWriter yamlWrite) {
        this.IParser = IParser;
        this.yamlReader = yamlReader;
        this.yamlWrite = yamlWrite;
    }

    private void init() {
        log.info("initialization");
        yamlReader.setPath(inputFile);
        yamlWrite.setPath(outputFile);
    }

    @Override
    public void startup() {
        init();
        long start = System.currentTimeMillis();
        log.info("Read file");
        List<String> yamlLines = yamlReader.read();
        log.info("Start parsing");
        yamlWrite.write(IParser.getConverterData(yamlLines));
        log.info("End parsing\nExecution time of the program: " + (System.currentTimeMillis() - start) + " ms");
    }
}
