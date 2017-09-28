package io.github.klsmith.dnd.persistance;

import java.util.Optional;

public interface FileLoader {

	<T> Optional<File<T>> load(String name, Location location, Class<T> type);

}
