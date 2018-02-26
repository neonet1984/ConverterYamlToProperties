package file;

import java.util.List;

/**
 * The interface is uses to read a file
 */
public interface IReader<T> {
    /**
     * The method read the  file
     *
     * @return List<T> read lines
     */
    List<T> read();
}
