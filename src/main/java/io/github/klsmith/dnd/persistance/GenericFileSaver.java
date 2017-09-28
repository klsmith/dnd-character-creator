package io.github.klsmith.dnd.persistance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.github.klsmith.dnd.serialization.Serializer;

public class GenericFileSaver<DATA> implements FileSaver {

    private final Serializer<DATA> serializer;

    private GenericFileSaver(Serializer<DATA> serializer) {
        this.serializer = serializer;
    }

    public static <DATA> GenericFileSaver<DATA> get(Serializer<DATA> serializer) {
        return new GenericFileSaver<>(serializer);
    }

    @Override
    public void save(File<?> file) {
        final Path path = getFilePath(file);
        final byte[] data = getData(file);
        try {
            Files.write(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Path getFilePath(File<?> file) {
        return Paths.get(file.getLocation().getLocationString() + file.getName());
    }

    private byte[] getData(File<?> file) {
        return serializer.serializeBytes(file);
    }

}
