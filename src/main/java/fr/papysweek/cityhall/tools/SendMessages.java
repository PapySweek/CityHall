package fr.papysweek.cityhall.tools;

import fr.papysweek.cityhall.managers.CityHallManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class SendMessages {
    private static String prefix = CityHallManager.getConfigManager().getConfig().getString("prefix");
    public static void sendMessageToCommandSenderWithPrefix(CommandSender commandSender, String message) {
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + message));
    }
}
