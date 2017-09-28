package io.github.klsmith.dnd.persistance;

public interface FileLoader {

    <DATA> File<DATA> load(String name, FileLocation location, Class<DATA> type);

}
