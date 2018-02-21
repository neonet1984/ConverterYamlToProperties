package file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {
    private static final Logger LOG = LoggerFactory.getLogger(ReadFile.class);
    private final String PATH_FILE_YAML;
    private List<String> yamlFile;

    public ReadFile(String path) {
        PATH_FILE_YAML = path;
        yamlFile = new ArrayList<>();
    }

    public List<String> readYaml() throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(PATH_FILE_YAML))) {
            yamlFile = stream
                    .filter(line -> !line.isEmpty() && !line.matches("^[#;].*") )
                    .collect(Collectors.toList());
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
        return yamlFile;
    }

}
