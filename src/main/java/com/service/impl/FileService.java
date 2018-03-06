package com.service.impl;

import com.service.IFile;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * The service uses receive yml all the files in the transferred directory
 */
@Service
public class FileService implements IFile {
    @Override
    public List<String> getListPaths(String pathDirectory) {
        List<String> fileNameList = new ArrayList<>();
        File directory = new File(pathDirectory);
        Arrays.stream(directory.listFiles())
                .filter(checkFileExtensions())
                .forEach(file -> fileNameList.add(file.toString()));
        return fileNameList;
    }

    @Override
    public void removeFile(String puthFile) {
        File file = new File(puthFile);
        file.delete();
    }

    private Predicate<? super File> checkFileExtensions() {
        return pathFile -> pathFile.toString().matches(".*\\.yml");
    }
}
