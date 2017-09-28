package io.github.klsmith.dnd.persistance.model;

import io.github.klsmith.dnd.util.Copyable;

public final class File<T> implements Copyable<File<T>> {

	private final transient String name;
	private final transient Location location;
	private final Data<T> data;

	private File(String name, Location location, Data<T> data) {
		this.name = name;
		this.location = location.getCopy();
		this.data = data;
	}

	public static <T> File<T> get(String name, Location location, Data<T> data) {
		return new File<>(name, location, data);
	}

	public String getName() {
		return name;
	}

	public Location getLocation() {
		return location;
	}

	public Data<T> getData() {
		return data;
	}

	@Override
	public File<T> getCopy() {
		return this;
	}

	public File<T> getCopy(String newName) {
		return get(newName, location.getCopy(), data);
	}

	public File<T> getCopy(Location newLocation) {
		return get(name, newLocation.getCopy(), data);
	}

	public File<T> getCopy(String newName, Location newLocation) {
		return get(newName, newLocation.getCopy(), data);
	}

}
