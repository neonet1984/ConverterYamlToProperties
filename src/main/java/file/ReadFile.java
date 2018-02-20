package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    private BufferedReader reader;

    private void openFile(String patch) throws FileNotFoundException {
        this.reader = new BufferedReader(new FileReader(patch));
    }

    public List<String> readYaml(String path) throws IOException {
        openFile(path);
        String line;
        List<String> fileYaml = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            fileYaml.add(line);
        }
        closeFile();
        return fileYaml;
    }

    private void closeFile() throws IOException {
        this.reader.close();
    }
}
