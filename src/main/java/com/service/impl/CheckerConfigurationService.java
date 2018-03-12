package com.service.impl;

import com.service.ICheckerConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * This service checks the configuration in app.properties
 */
@Service
public class CheckerConfigurationService implements ICheckerConfiguration {
    private static final Logger log = LoggerFactory.getLogger(CheckerConfigurationService.class);
    @Value("${directory.source.files}")
    private String directorySourceFiles;
    @Value("${directory.out.files}")
    private String directoryOutputFiles;
    @Value("${directory.notvalid.files}")
    private String directoryNotValidFiles;
    @Value("${directory.converted.files}")
    private String directoryWithConvertedFiles;

    @Override
    public boolean isCheckPropertiesConfig() {
        return isCheckDirectory();
    }

    private boolean isCheckDirectory() {
        return Arrays.asList(
                directorySourceFiles, directoryOutputFiles,
                directoryNotValidFiles, directoryWithConvertedFiles)
                .stream()
                .noneMatch(directoryPath -> isCheckDirectoryPuth(directoryPath));
    }

    private boolean isCheckDirectoryPuth(String puth) {
        if (!Files.exists(Paths.get(puth))) {
            log.error("Directory " + puth + " not found");
            return true;
        } else {
            return false;
        }
    }
}