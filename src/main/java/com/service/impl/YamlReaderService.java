package com.service.impl;

import com.service.IReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The class is uses to reader yaml a file
 */
@Service
public class YamlReaderService implements IReader {
    private static final Logger log = LoggerFactory.getLogger(YamlReaderService.class);
    private String pathFileYaml;

    @Override
    public List<String> read() {
        log.info("Read yaml file");
        try (Stream<String> stream = Files.lines(Paths.get(pathFileYaml))) {
            return stream
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error("Error reading file", e);
        }
        return Collections.emptyList();
    }

    @Override
    public void setPath(String pathToFile) {
        pathFileYaml = pathToFile;
    }

}
