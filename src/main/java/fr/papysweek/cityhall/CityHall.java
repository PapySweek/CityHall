package fr.papysweek.cityhall;

import fr.papysweek.cityhall.managers.CityHallManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * My plugin will be a rp plugin for a city
 */
public final class CityHall extends JavaPlugin {
    private static CityHall instance;

    /**
     * In the onEnable i will load all components for the plugins, configManager, commandManager, eventManager
     */
    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        CityHallManager.enable();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        CityHallManager.disable();
    }

    public static CityHall getInstance() {
        return instance;
    }
}
