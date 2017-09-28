package io.github.klsmith.dnd.persistance.model;

public class GenericLocation implements Location {

    private static final String JAVA_FILE_DELIMITER = "/";
    private final String location;

    private GenericLocation(String location) {
        this.location = location;
    }

    public static GenericLocation get(String path) {
        return new GenericLocation(getValidLocationString(path));
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
    public Location getCopy() {
        return this;
    }

}
