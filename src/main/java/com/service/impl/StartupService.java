package com.service.impl;

import com.service.*;
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
    private final ICheckerConfiguration checkerConfigurationService;

    /**
     * The constructor initializes the value fields, for the initialization
     */
    @Autowired
    public StartupService(IParser parserService, IFileAdapter fileAdapterService, IValidator validatorService,
                          ICheckerConfiguration checkerConfiguration) {
        this.parserService = parserService;
        this.fileAdapterService = fileAdapterService;
        this.validatorService = validatorService;
        this.checkerConfigurationService = checkerConfiguration;
    }

    @Scheduled(fixedRateString = "${time.out}")
    @Override
    public void startup() {
        if (checkerConfigurationService.isCheckPropertiesConfig()) {
            processing();
        }else {
            System.exit(1);
        }
    }

    private void processing() {
        checkerConfigurationService.isCheckPropertiesConfig();
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
