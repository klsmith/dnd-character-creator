package io.github.klsmith.dnd.persistance;

import java.util.Optional;

import io.github.klsmith.dnd.persistance.model.File;
import io.github.klsmith.dnd.persistance.model.Location;

public interface FileLoader {

	<T> Optional<File<T>> load(String name, Location location, Class<T> type);

}
