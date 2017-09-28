package io.github.klsmith.dnd.persistance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

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
	public <T> Optional<File<T>> load(String name, Location location, Class<T> type) {
		final Path path = PersistanceUtil.getFilePath(name, location);
		final Optional<byte[]> fileBytes = getFileBytes(path);
		if (fileBytes.isPresent()) {
			final Optional<T> fileData = serializer.deserializeBytes(fileBytes.get(), type);
			if (fileData.isPresent()) {
				return Optional.of(File.get(name, location.getCopy(), fileData.get()));
			}
		}
		return Optional.empty();
	}

	private Optional<byte[]> getFileBytes(Path path) {
		try {
			return Optional.ofNullable(Files.readAllBytes(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}
