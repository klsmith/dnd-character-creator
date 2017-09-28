package io.github.klsmith.dnd.persistance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import io.github.klsmith.dnd.persistance.model.File;
import io.github.klsmith.dnd.serialization.Serializer;

public class GenericFileSaver<S> implements FileSaver {

	private final Serializer<S> serializer;

	private GenericFileSaver(Serializer<S> serializer) {
		this.serializer = serializer;
	}

	public static <S> GenericFileSaver<S> get(Serializer<S> serializer) {
		return new GenericFileSaver<>(serializer);
	}

	@Override
	public void save(File<?> file) {
		final Path path = PersistanceUtil.getFilePath(file);
		final byte[] data = getData(file);
		try {
			Files.write(path, data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private byte[] getData(File<?> file) {
		return serializer.serializeBytes(file.getData());
	}

}
