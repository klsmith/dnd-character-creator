package io.github.klsmith.dnd;

import io.github.klsmith.dnd.persistance.File;
import io.github.klsmith.dnd.persistance.FileLocation;
import io.github.klsmith.dnd.persistance.FileSaver;
import io.github.klsmith.dnd.persistance.GenericFile;
import io.github.klsmith.dnd.persistance.GenericFileLocation;
import io.github.klsmith.dnd.persistance.GenericFileSaver;
import io.github.klsmith.dnd.serialization.JsonSerializer;
import io.github.klsmith.dnd.serialization.Serializer;

public class App {

    public static void main(String[] args) {
        final Serializer<?> serializer = JsonSerializer.get();
        final FileSaver fileSaver = GenericFileSaver.get(serializer);
        final FileLocation location = GenericFileLocation.get("/temp/");
        final File<?> file = GenericFile.get("mycharacter.json", location, "Hello World");
        fileSaver.save(file);
    }

}
