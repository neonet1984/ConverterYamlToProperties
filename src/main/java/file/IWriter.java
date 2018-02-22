package file;

import java.util.List;

public interface IWriter<T> {
    void write(List<T> PropertiesLines);
}
