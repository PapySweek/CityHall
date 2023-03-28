package fr.papysweek.cityhall.commands;

import fr.papysweek.cityhall.managers.data.JSONStorage;
import fr.papysweek.cityhall.managers.data.PlayerStatsJson;
import fr.papysweek.cityhall.tools.SendMessages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class JsonStorageCommand implements CommandExecutor {

    private PlayerStatsJson playerStatsJson;
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!command.getName().equalsIgnoreCase("jsonstorage")) return false;
        if (!(commandSender instanceof Player)) return false;
        Player player = (Player) commandSender;

        if (strings.length == 0 || strings.length > 1) {
            player.sendMessage("Usage: /jsonstorage <value>");
            return true;
        }

        playerStatsJson = new PlayerStatsJson(player);

        if (strings[0].equalsIgnoreCase("read")) {
            SendMessages.sendMessageToCommandSenderWithPrefix(player, playerStatsJson.readStats());

        } else if (strings[0].equalsIgnoreCase("write")){
            playerStatsJson.writeStats();
            SendMessages.sendMessageToCommandSenderWithPrefix(player, "&3Stats saved");
        }

        return true;
    }
}
