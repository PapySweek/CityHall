package fr.papysweek.cityhall.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class TownHallDamageEvent implements Listener {
    /**
     * This event will be called when a player will be damaged in the townhall
     * This event will be cancelled if the player is in the townhall
     * @param event
     */
    @EventHandler
    public void onPlayerDamageInTownHall(EntityDamageEvent event) {
        //TODO: check if the entity is a player, check if the player is in the townhall, cancel the event
        if(!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        if (player.getLocation().getWorld().getName().equalsIgnoreCase("world")) {
            event.setCancelled(true);
        }

    }
}
