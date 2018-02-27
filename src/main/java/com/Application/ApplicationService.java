package com.Application;

import com.file.IReader;
import com.file.IWriter;
import com.parser.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

/**
 * The class encapsulates read file,parsing file and write file
 */
@Service
public class ApplicationService implements Application {
    private static final Logger log = LoggerFactory.getLogger(ApplicationService.class);
    @Autowired
    Properties properties;

    @Autowired
    Parser parser;

    @Autowired
    IReader yamlReader;

    @Autowired
    IWriter yamlWrite;

    private void init() {
        log.info("initialization");
        String intputFile = properties.getProperty("input.file");
        String outputFile = properties.getProperty("output.file");
        yamlReader.setPath(intputFile);
        yamlWrite.setPath(outputFile);
    }

    @Override
    public void startup() {
        init();
        long start = System.currentTimeMillis();
        log.info("Read file");
        List<String> yamlLines = yamlReader.read();
        log.info("Start parsing");
        yamlWrite.write(parser.getConverterData(yamlLines));
        log.info("End parsing\nExecution time of the program: " + (System.currentTimeMillis() - start) + " ms");
    }
}
