package io.github.klsmith.dnd.persistance;

import io.github.klsmith.dnd.util.Copyable;

public interface FileLocation extends Copyable<FileLocation> {

    String getLocationString();

}
