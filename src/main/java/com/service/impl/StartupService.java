package com.service.impl;

import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

/**
 * The class encapsulates read file,parsing file and write file
 */
@Service
public class StartupService implements IStartup {
    private final IParser parserService;
    private final IFileAdapter fileAdapterService;
    private final IDirectory directoryService;
    private final IValidator validatorService;

    /**
     * The constructor initializes the value fields, for the initialization
     */
    @Autowired
    public StartupService(IParser parserService, IFileAdapter fileAdapterService, IDirectory directoryService,
                          IValidator validatorService) {
        this.parserService = parserService;
        this.fileAdapterService = fileAdapterService;
        this.directoryService = directoryService;
        this.validatorService = validatorService;
    }

    @Scheduled(fixedRateString = "${time.out}")
    @Override
    public void startup() {
        if (directoryService.isCorrectnessDirectories()) {
            processing();
        } else {
            System.exit(1);
        }
    }

    private void processing() {
        fileAdapterService.getListPaths().forEach(this::processing);
    }

    private void processing(String path) {
        Stream
                .of(fileAdapterService.readFile(path))
                .forEach(values -> {
                            if (validatorService.checkLines(values)) {
                                writeValuesAndRemoveFile(values, path);
                            } else {
                                moveFile(path);
                            }
                        }
                );
    }

    private void writeValuesAndRemoveFile(List<String> values, String path) {
        fileAdapterService.write(parserService.getConverterData(values));
        fileAdapterService.moveFileToDirectoryWithConvertedFiles(path);
    }

    private void moveFile(String path) {
        fileAdapterService.moveFileToDirectoryNotValidFiles(path);
    }
}
