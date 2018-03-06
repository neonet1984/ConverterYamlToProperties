package com.service.impl;

import com.service.IFileAdapter;
import com.service.IParser;
import com.service.IStartup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The class encapsulates read file,parsing file and write file
 */
@Service
public class StartupService implements IStartup {
    private final IParser parser;
    private final IFileAdapter fileAdapter;

    @Autowired
    public StartupService(IParser parser, IFileAdapter fileAdapter) {
        this.parser = parser;
        this.fileAdapter = fileAdapter;
    }

    @Scheduled(fixedRateString  = "${time.out}")
    public void startup() {
        List<String> listPaths = fileAdapter.getListPaths();
        if (!listPaths.isEmpty()) {
            listPaths.forEach(this::processing);
        }
    }

    private void processing(String path) {
        fileAdapter.write(parser.getConverterData(fileAdapter.readFile(path)));
        fileAdapter.removeFile(path);
    }
}
