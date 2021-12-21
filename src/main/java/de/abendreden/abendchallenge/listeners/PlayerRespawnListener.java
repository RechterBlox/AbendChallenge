package de.abendreden.abendchallenge.listeners;

import de.abendreden.abendchallenge.AbendChallenge;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener implements Listener {

    private final AbendChallenge plugin;

    public PlayerRespawnListener(AbendChallenge abendChallenge) {
        this.plugin = abendChallenge;
    }

    @EventHandler
    public void handleOnRespawn(PlayerRespawnEvent respawnEvent) {
        if (plugin.challenge.contains(1)) {
            Player player = respawnEvent.getPlayer();
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    player.setHealth(2);
                }
            }, 1);
        }
    }
}
