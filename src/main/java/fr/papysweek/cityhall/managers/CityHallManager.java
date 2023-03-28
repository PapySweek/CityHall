package fr.papysweek.cityhall.managers;

import fr.papysweek.cityhall.CityHall;

public class CityHallManager {
        private static ConfigManager configManager;

        public static void enable() {
                //load configManager

                configManager = new ConfigManager();
                configManager.createConfig();
                //load RegisterManager
                RegisterManager.register();
        }

        public static void disable() {

        }

        public static ConfigManager getConfigManager() {
                return configManager;
        }
}
