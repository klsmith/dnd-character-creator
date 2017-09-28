package io.github.klsmith.dnd.persistance;

public class GenericFileLocation implements FileLocation {

    private static final String JAVA_FILE_DELIMITER = "/";
    private final String location;

    private GenericFileLocation(String location) {
        this.location = location;
    }

    public static GenericFileLocation get(String path) {
        return new GenericFileLocation(getValidLocationString(path));
    }

    public static String getValidLocationString(String location) {
        if (location.endsWith(JAVA_FILE_DELIMITER)) {
            return location;
        }
        return location + JAVA_FILE_DELIMITER;
    }

    @Override
    public String getLocationString() {
        return location;
    }

    @Override
    public FileLocation getCopy() {
        return this;
    }

}
