package io.github.klsmith.dnd.persistance;

import java.nio.file.Path;
import java.nio.file.Paths;

import io.github.klsmith.dnd.persistance.model.File;
import io.github.klsmith.dnd.persistance.model.Location;

public class PersistanceUtil {

	public static Path getFilePath(File<?> file) {
		return getFilePath(file.getName(), file.getLocation());
	}

	public static Path getFilePath(String name, Location location) {
		return Paths.get(location.getLocationString() + name);
	}

}
