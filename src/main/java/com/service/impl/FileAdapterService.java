package com.service.impl;

import com.service.IFile;
import com.service.IFileAdapter;
import com.service.IReader;
import com.service.IWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * The class encapsulates the service for reading and the service for writing files
 */
@Service
public class FileAdapterService implements IFileAdapter {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss");
    private static final Logger log = LoggerFactory.getLogger(StartupService.class);
    private final IReader yamlReaderService;
    private final IWriter yamlWriteService;
    private final IFile fileService;
    @Value("${directory.source}")
    private String directorySourceFiles;
    @Value("${directory.out:directory_output}")
    private String directoryOutputFiles;
    @Value("${directory.error:directory_error}")
    private String directoryNotValidFiles;
    @Value("${directory.success:directory_success}")
    private String directoryWithConvertedFiles;

    /**
     * The constructor initializes the value fields, for the initialization
     * it receives from app.properties
     *
     * @param yamlReaderService Service for reader yaml
     * @param fileService       Service for write properties
     */
    @Autowired
    public FileAdapterService(IReader yamlReaderService, IWriter yamlWriteService, IFile fileService) {
        this.yamlReaderService = yamlReaderService;
        this.yamlWriteService = yamlWriteService;
        this.fileService = fileService;
    }

    @Override
    public List readFile(String pathToFile) {
        yamlReaderService.setPath(pathToFile);
        return yamlReaderService.read();
    }

    @Override
    public void write(List<StringBuilder> values) {
        yamlWriteService.setPath(getOutputPath());
        yamlWriteService.write(values);
    }

    @Override
    public void moveFileToDirectoryNotValidFiles(String pathToFile) {
        log.info("Moving a file to a directory with non-valid files");
        moveFile(pathToFile, directoryNotValidFiles);
    }

    @Override
    public void moveFileToDirectoryWithConvertedFiles(String pathToFile) {
        log.info("Moving a file to the directory with converted files");
        moveFile(pathToFile, directoryWithConvertedFiles);
    }

    @Override
    public void moveFile(String pathToFile, String toDirectory) {
        fileService.moveFile(pathToFile, toDirectory);
    }

    @Override
    public List<String> getListPaths() {
        return fileService.getListPaths(directorySourceFiles);
    }

    private String getOutputPath() {
        return directoryOutputFiles + "\\" + dateFormat.format(new Date()) + "." + new Random().nextInt() + ".properties";
    }
}
