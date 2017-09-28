package io.github.klsmith.dnd.persistance;

/**
 * An interface representing the generic ability to save FileData objects to and
 * from the file system. <br/>
 * <br/>
 * <strong>Classes that implement this interface must be thread safe.</strong>
 * 
 * @author Kooper Smith
 */
public interface FileSaver {

    /**
     * Save a FileData object to the file system.
     * 
     * @param file
     *            the FileData object to be saved to the file system.
     */
    void save(File<?> file);

}