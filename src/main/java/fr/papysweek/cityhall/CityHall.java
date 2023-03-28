package fr.papysweek.cityhall;

import fr.papysweek.cityhall.managers.CityHallManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class CityHall extends JavaPlugin {
    private static CityHall instance;

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
