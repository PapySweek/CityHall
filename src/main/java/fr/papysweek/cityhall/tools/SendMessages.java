package fr.papysweek.cityhall.tools;

import fr.papysweek.cityhall.managers.MCFileManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

public class SendMessages {

    private static YamlConfiguration config = MCFileManager.BASE_CONFIG.getYamlConfig();
    private static String prefix = config.getString("prefix");
    public static void sendMessageToCommandSenderWithPrefix(CommandSender commandSender, String message) {
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + message));
    }
}
