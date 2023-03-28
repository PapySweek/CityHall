package fr.papysweek.cityhall.managers;

import fr.papysweek.cityhall.CityHall;

public class CityHallManager {

        public static void enable() {
                //load configManager
                for (MCFileManager mcFileManager : MCFileManager.defaultFiles){
                        mcFileManager.create(CityHall.getInstance().getLogger());
                }
                //load RegisterManager
                RegisterManager.register();
        }

        public static void disable() {

        }
}
