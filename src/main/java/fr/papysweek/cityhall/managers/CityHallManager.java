package fr.papysweek.cityhall.managers;

import fr.papysweek.cityhall.CityHall;

public class CityHallManager {

        public static void enable() {
                //load configManager
                for (MCFile mcFile : MCFile.defaultFiles){
                        mcFile.create(CityHall.getInstance().getLogger());
                }
                //load RegisterManager
                RegisterManager.register();
        }

        public static void disable() {

        }
}
