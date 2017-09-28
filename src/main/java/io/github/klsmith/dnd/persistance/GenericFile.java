package io.github.klsmith.dnd.persistance;

public class GenericFile<DATA> implements File<DATA> {

    private final transient String name;
    private final transient FileLocation location;
    private final DATA data;

    private GenericFile(String name, FileLocation location, DATA data) {
        this.name = name;
        this.location = location.getCopy();
        this.data = data;
    }

    public static <DATA> GenericFile<DATA> get(String name, FileLocation location, DATA data) {
        return new GenericFile<>(name, location, data);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public FileLocation getLocation() {
        return location;
    }

    @Override
    public DATA getData() {
        return data;
    }

    @Override
    public File<DATA> getCopy() {
        return this;
    }

    @Override
    public File<DATA> getCopy(String newName) {
        return get(newName, location, data);
    }

    @Override
    public File<DATA> getCopy(FileLocation newLocation) {
        return get(name, newLocation, data);
    }

    @Override
    public File<DATA> getCopy(String newName, FileLocation newLocation) {
        return get(newName, newLocation, data);
    }

}
