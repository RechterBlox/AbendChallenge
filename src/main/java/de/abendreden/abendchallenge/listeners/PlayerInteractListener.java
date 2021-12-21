package de.abendreden.abendchallenge.listeners;

import de.abendreden.abendchallenge.AbendChallenge;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class PlayerInteractListener implements Listener {

    private final AbendChallenge plugin;

    public PlayerInteractListener(AbendChallenge abendChallenge) {
        this.plugin = abendChallenge;
    }

    @EventHandler
    public void handleOnOpenInventory(PlayerInteractEvent interactEvent) {
        if (plugin.challenge.contains(2)) {
            if (interactEvent.getAction().isRightClick()) {
                if (Objects.requireNonNull(interactEvent.getClickedBlock()).getType().equals(Material.CRAFTING_TABLE)) {
                    interactEvent.setCancelled(true);
                }
            }
        }
    }
}
