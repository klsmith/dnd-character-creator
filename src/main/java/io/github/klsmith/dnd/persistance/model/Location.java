package io.github.klsmith.dnd.persistance.model;

import io.github.klsmith.dnd.util.Copyable;

public final class Location implements Copyable<Location> {

	private static final String JAVA_FILE_DELIMITER = "/";
	private final String location;

	private Location(String location) {
		this.location = location;
	}

	public static Location at(String path) {
		return new Location(getValidLocationString(path));
	}

	public static String getValidLocationString(String location) {
		if (location.endsWith(JAVA_FILE_DELIMITER)) {
			return location;
		}
		return location + JAVA_FILE_DELIMITER;
	}

	public String getLocationString() {
		return location;
	}

	@Override
	public Location getCopy() {
		return this;
	}

}
