package fr.papysweek.cityhall.managers;

import fr.papysweek.cityhall.CityHall;
import fr.papysweek.cityhall.commands.CityHallCommand;
import fr.papysweek.cityhall.events.TownHallDamageEvent;

public class RegisterManager {

    public static void register() {
        //register commandManager
        registerCommand();
        //register eventManager
        registerEvents();
    }

    private static void registerCommand() {
        //register command
        CityHall.getInstance().getCommand("cityhall").setExecutor(new CityHallCommand());
    }

    private static void registerEvents() {
        //register events with bukkit api
        CityHall.getInstance().getServer().getPluginManager().registerEvents(new TownHallDamageEvent(), CityHall.getInstance());
    }

}
