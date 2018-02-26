package file;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The class is uses to reader yaml a file
 */
public class YamlReader implements IReader<String> {
    private static final Logger log = LoggerFactory.getLogger(YamlReader.class);
    private final String PATH_FILE_YAML;

    public YamlReader(String path) {
        PATH_FILE_YAML = path;
    }

    @Override
    public List<String> read() {
        Predicate<String> predicateForFilter = line ->line.isEmpty()  && !checkForComments(line);
        try (Stream<String> stream = Files.lines(Paths.get(PATH_FILE_YAML))) {
            return stream
                    .filter(predicateForFilter)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error("Error reading file", e);
        }
        return Collections.emptyList();
    }
    private boolean checkForComments(String line){
        return line.matches("^[#;].*");
    }
}
