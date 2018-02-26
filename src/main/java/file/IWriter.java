package file;

import java.util.List;

/**
 * The interface is uses to write a file
 */
public interface IWriter<T> {
    /**
     * The method writes the properties file
     *
     * @param listLines the input receives a list of rows for writing
     */
    void write(List<T> listLines);
}
