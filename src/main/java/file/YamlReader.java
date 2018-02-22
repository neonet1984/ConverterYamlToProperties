package file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The class is used  to read a yaml file
 */
public class YamlReader implements IReader<String> {
    private static final Logger Log = LoggerFactory.getLogger(YamlReader.class);
    private final String PATH_FILE_YAML;

    public YamlReader(String path) {
        PATH_FILE_YAML = path;
    }

    /**
     * The method reads the yaml file
     *
     * @return list of lines of the yaml file
     */
    @Override
    public List<String> read() {
        Predicate<String> predicate = line -> !line.isEmpty() && !line.matches("^[#;].*");
        try (Stream<String> stream = Files.lines(Paths.get(PATH_FILE_YAML))) {
            return stream
                    .filter(predicate)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            Log.error("Error reading file", e);
        }
        return null;
    }
}
