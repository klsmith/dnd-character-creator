package io.github.klsmith.dnd.persistance.model;

import io.github.klsmith.dnd.util.Copyable;

public interface Location extends Copyable<Location> {

    String getLocationString();

}
