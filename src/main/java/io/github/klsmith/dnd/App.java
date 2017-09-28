package io.github.klsmith.dnd;

import io.github.klsmith.dnd.persistance.FileLoader;
import io.github.klsmith.dnd.persistance.FileSaver;
import io.github.klsmith.dnd.persistance.GenericFileLoader;
import io.github.klsmith.dnd.persistance.GenericFileSaver;
import io.github.klsmith.dnd.persistance.model.File;
import io.github.klsmith.dnd.persistance.model.GenericLocation;
import io.github.klsmith.dnd.persistance.model.Location;
import io.github.klsmith.dnd.serialization.JsonSerializer;
import io.github.klsmith.dnd.serialization.Serializer;

public final class App {

	private static Serializer<?> serializer;
	private static FileSaver saver;
	private static FileLoader loader;

	private static String name;
	private static Location location;
	private static String data;

	public static void main(String[] args) {
		initTools();
		initData();
		testSaving();
		testLoading();
	}

	private static void initTools() {
		serializer = JsonSerializer.get();
		saver = GenericFileSaver.get(serializer);
		loader = GenericFileLoader.get(serializer);
	}

	private static void initData() {
		name = "character.json";
		location = GenericLocation.get("/temp/");
		data = "Hello World";
	}

	private static void testSaving() {
		final File<?> fileToSave = File.get(name, location, data);
		System.out.println("Saving...");
		printFile(fileToSave);
		saver.save(fileToSave);
		System.out.println("Done!");
		System.out.println();
	}

	private static void testLoading() {
		System.out.println("Loading...");
		loader.load(name, location, String.class).ifPresent(App::printFile);
		System.out.println("Done!");
	}

	private static void printFile(File<?> fileToPrint) {
		System.out.println(serializer.serialize(fileToPrint));
	}

}
