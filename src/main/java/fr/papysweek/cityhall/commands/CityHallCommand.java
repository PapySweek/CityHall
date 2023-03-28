package fr.papysweek.cityhall.commands;

import fr.papysweek.cityhall.CityHall;
import fr.papysweek.cityhall.managers.CityHallManager;
import fr.papysweek.cityhall.tools.SendMessages;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CityHallCommand implements @Nullable CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        // print plugins info for cityhall plugin to the commandSender
        if (command.getName().equalsIgnoreCase("cityhall")) {
            String prefix = CityHallManager.getConfigManager().getConfig().getString("prefix");
            SendMessages.sendMessageToCommandSenderWithPrefix(commandSender," &cCityHall Plugin by &6Papysweek");
            SendMessages.sendMessageToCommandSenderWithPrefix(commandSender, " &cVersion: &6"+ CityHall.getInstance().getDescription().getVersion());
            SendMessages.sendMessageToCommandSenderWithPrefix(commandSender," &cDescription: &6My plugin is a plugin for managing a city hall in a survival server");
        }
        return true;
    }
}
