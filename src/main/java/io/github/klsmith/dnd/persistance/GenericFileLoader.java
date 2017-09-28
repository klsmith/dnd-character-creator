package io.github.klsmith.dnd.persistance;

import java.nio.file.Path;
import java.nio.file.Paths;

import io.github.klsmith.dnd.serialization.Serializer;

public class GenericFileLoader<S> implements FileLoader {

    private final Serializer<S> serializer;

    private GenericFileLoader(Serializer<S> serializer) {
        this.serializer = serializer;
    }

    public static <S> GenericFileLoader<S> get(Serializer<S> serializer) {
        return new GenericFileLoader<>(serializer);
    }

    @Override
    public <DATA> File<DATA> load(String name, FileLocation location, Class<DATA> type) {
        final Path path = getFilePath(name, location);
        return null;
    }

    private Path getFilePath(String name, FileLocation location) {
        return Paths.get(location.getLocationString() + name);
    }

}
