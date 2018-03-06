package com.service.impl;

import com.service.IFile;
import com.service.IFileAdapter;
import com.service.IReader;
import com.service.IWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The class encapsulates the service for reading and the service for writing files
 */
@Service
public class FileAdapterService implements IFileAdapter {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss");
    private final IReader yamlReader;
    private final IWriter yamlWrite;
    private final IFile iFile;
    @Value("${input.directory}")
    private String inputDirectory;
    @Value("${output.directory}")
    private String outputDirectory;

    /**
     * The constructor initializes the value fields, for the initialization
     * it receives from app.properties
     *
     * @param yamlReader Service for reader yaml
     * @param yamlWrite Service for write properties
     */
    @Autowired
    public FileAdapterService(IReader yamlReader, IWriter yamlWrite, IFile iFile) {
        this.yamlReader = yamlReader;
        this.yamlWrite = yamlWrite;
        this.iFile = iFile;
    }

    @Override
    public List readFile(String path) {
        yamlReader.setPath(path);
        return yamlReader.read();
    }

    @Override
    public void write(List<StringBuilder> values) {
        yamlWrite.setPath(getOutputPath());
        yamlWrite.write(values);
    }

    @Override
    public void removeFile(String path) {
        iFile.removeFile(path);
    }

    @Override
    public List<String> getListPaths() {
        return iFile.getListPaths(inputDirectory);
    }

    private String getOutputPath() {
        return outputDirectory + "\\" + dateFormat.format(new Date()) + ".properties";
    }
}
