package fr.papysweek.cityhall.managers;

import fr.papysweek.cityhall.CityHall;
import fr.papysweek.cityhall.commands.CityHallCommand;
import fr.papysweek.cityhall.commands.JsonStorageCommand;
import fr.papysweek.cityhall.commands.tab_completer.JsonStorageTabCompleter;
import fr.papysweek.cityhall.events.TownHallDamageEvent;

public class RegisterManager {

    public static void register() {
        //register commandManager
        registerCommand();
        registerTabCompleter();
        //register eventManager
        registerEvents();
    }

    private static void registerCommand() {
        //register command
        CityHall.getInstance().getCommand("cityhall").setExecutor(new CityHallCommand());
        CityHall.getInstance().getCommand("jsonstorage").setExecutor(new JsonStorageCommand());
    }

    private static void registerTabCompleter() {
        //register tabCompleter
        CityHall.getInstance().getCommand("jsonstorage").setTabCompleter(new JsonStorageTabCompleter());
    }

    private static void registerEvents() {
        //register events with bukkit api
        CityHall.getInstance().getServer().getPluginManager().registerEvents(new TownHallDamageEvent(), CityHall.getInstance());
    }

}
