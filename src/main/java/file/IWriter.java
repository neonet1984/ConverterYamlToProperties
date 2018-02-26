package file;

import java.util.List;

/**
 * The interface is uses to write a file
 */
public interface IWriter<T> {
    /**
     * The method writes the properties file
     *
     * @param values the input receives a list of rows for writing
     */
    void write(List<T> values);
}
