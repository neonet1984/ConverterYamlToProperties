package com.service.impl;

import com.service.IFile;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The service uses receive yml all the files in the transferred directory
 */
@Service
public class FileService implements IFile {
    private static final Logger log = LoggerFactory.getLogger(FileService.class);

    @Override
    public List<String> getListPaths(String pathDirectory){
        return Arrays.stream(new File(pathDirectory).listFiles())
                .filter(checkFileExtensions())
                .map(file -> file.toString())
                .collect(Collectors.toList());
    }

    @Override
    public void moveFile(String pathFile, String pathDirectory) {
        File file = new File(pathFile);
        try {
            FileUtils.copyFileToDirectory(file, new File(pathDirectory));
            file.delete();
        } catch (IOException e) {
            log.info("Uninstall error or copy error",e.getMessage());
        }
    }

    private Predicate<? super File> checkFileExtensions() {
        return pathFile -> pathFile.toString().matches(".*\\.yml");
    }

}
