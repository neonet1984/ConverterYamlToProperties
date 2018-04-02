package com.service.impl;

import com.service.IDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * This class checks for the existence of the directories specified in app.properties. If the specified directories are
 * not present, then the class creates them
 */
@Service
public class DirectoryService implements IDirectory {
    private static final Logger log = LoggerFactory.getLogger(DirectoryService.class);
    @Value("${directory.source}")
    private String directorySourceFiles;
    @Value("${directory.out:directory_output}")
    private String directoryOutputFiles;
    @Value("${directory.error:directory_error}")
    private String directoryErrorFiles;
    @Value("${directory.success:directory_success}")
    private String directorySuccessFiles;

    @Override
    public boolean isCorrectnessDirectories() {
        return isSourceDirectoryExists(directorySourceFiles) && isRemainingDirectoriesExists();
    }

    private boolean isRemainingDirectoriesExists() {
        return Stream
                .of(directoryOutputFiles, directoryErrorFiles, directorySuccessFiles)
                .allMatch(this::isDirectory);
    }

    private boolean isSourceDirectoryExists(String directoryPath) {
        if (!isDirectoryExists(directoryPath)) {
            log.error("Source directory not found " + directoryPath);
            return false;
        } else {
            return true;
        }
    }

    private boolean isDirectoryExists(String directoryPath) {
        return Files.exists(Paths.get(directoryPath));
    }

    private boolean isDirectory(String directoryPath) {
        return (isDirectoryExists(directoryPath) || createDirectory(directoryPath));
    }

    private boolean createDirectory(String pathDirectory) {
        if (!new File(pathDirectory).mkdirs()) {
            log.error("Can not create a directory " + pathDirectory);
            return false;
        } else {
            return true;
        }
    }
}
