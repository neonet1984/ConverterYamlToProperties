package com.service.impl;

import com.service.IFileAdapter;
import com.service.IParser;
import com.service.IStartup;
import com.service.IValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The class encapsulates read file,parsing file and write file
 */
@Service
public class StartupService implements IStartup {
    private final IParser parserService;
    private final IFileAdapter fileAdapterService;
    private final IValidator validatorService;

    /**
     * The constructor initializes the value fields, for the initialization
     */
    @Autowired
    public StartupService(IParser parserService, IFileAdapter fileAdapterService, IValidator validatorService) {
        this.parserService = parserService;
        this.fileAdapterService = fileAdapterService;
        this.validatorService = validatorService;
    }

    @Scheduled(fixedRateString = "${time.out}")
    @Override
    public void startup() {
        List<String> listPaths = fileAdapterService.getListPaths();
        if (!listPaths.isEmpty()) {
            listPaths.forEach(this::processing);
        }
    }

    private void processing(String path) {
        List<String> values = fileAdapterService.readFile(path);
        if (validatorService.checkLines(values)) {
            fileAdapterService.write(parserService.getConverterData(values));
            fileAdapterService.moveFileToDirectoryWithConvertedFiles(path);
        } else {
            fileAdapterService.moveFileToDirectoryNotValidFiles(path);
        }
    }
}
