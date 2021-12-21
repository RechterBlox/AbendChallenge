package de.abendreden.abendchallenge.listeners;

import de.abendreden.abendchallenge.AbendChallenge;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class EntityRegainHealthListener implements Listener {

    private final AbendChallenge plugin;

    public EntityRegainHealthListener(AbendChallenge abendChallenge) {
        this.plugin = abendChallenge;
    }

    @EventHandler
    public void handleOnRegainHealth(EntityRegainHealthEvent regainHealthEvent) {
        if (plugin.challenge.size() != 0) {
            if (plugin.challenge.contains(1)) {
                if (regainHealthEvent.getEntity() instanceof Player player) {
                    if (player.getHealth() == 2) {
                        regainHealthEvent.setCancelled(true);
                    }
                    if (player.getHealth() >= 2) {
                        player.setHealth(2);
                        regainHealthEvent.setCancelled(true);
                    }
                }
            }
        }
    }
}
