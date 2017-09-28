package io.github.klsmith.dnd.model;

public class HealthPool {

    private final long baseMaxHealth;
    private final long currentMaxHealth;
    private final long currentHealth;

    private HealthPool() {
        baseMaxHealth = 0;
        currentMaxHealth = 0;
        currentHealth = 0;
    }

}
