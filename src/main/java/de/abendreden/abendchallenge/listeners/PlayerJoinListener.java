package de.abendreden.abendchallenge.listeners;

import de.abendreden.abendchallenge.AbendChallenge;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final AbendChallenge plugin;

    public PlayerJoinListener(AbendChallenge abendChallenge) {
        this.plugin = abendChallenge;
    }

    @EventHandler
    public void handleOnJoin(PlayerJoinEvent joinEvent) {
        if (plugin.challenge.contains(1)) {
            Player player = joinEvent.getPlayer();
            player.setHealth(2);
        }
    }
}
