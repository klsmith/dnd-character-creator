package io.github.klsmith.dnd.persistance;

import io.github.klsmith.dnd.util.Copyable;

public interface File<DATA> extends Copyable<File<DATA>> {

    String getName();

    FileLocation getLocation();

    DATA getData();

    File<DATA> getCopy(String newName);

    File<DATA> getCopy(FileLocation newLocation);

    File<DATA> getCopy(String newName, FileLocation newLocation);

}
