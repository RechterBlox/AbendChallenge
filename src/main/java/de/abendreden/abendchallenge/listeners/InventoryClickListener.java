package de.abendreden.abendchallenge.listeners;

import de.abendreden.abendchallenge.AbendChallenge;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


import java.util.Objects;

public class InventoryClickListener implements Listener {

    private final AbendChallenge plugin;

    public InventoryClickListener(AbendChallenge abendChallenge) {
        this.plugin = abendChallenge;
    }

    @EventHandler
    public void handleOnClick(InventoryClickEvent clickEvent) {
        if (clickEvent.getView().title().equals(Component.text(ChatColor.GOLD + "Challenge"))) {
            Player player = (Player) clickEvent.getWhoClicked();
            clickEvent.setCancelled(true);
            if (Objects.requireNonNull(clickEvent.getCurrentItem()).getType().equals(Material.RED_TULIP)) {
                   if (plugin.challenge.size() == 0) {
                       plugin.challenge.add(1);
                       for (Player allPlayer : Bukkit.getOnlinePlayers()) {
                           allPlayer.setHealth(2);
                       }
                       Bukkit.broadcast(Component.text(player.getName() + " hat die Challenge 1 gestartet"));
                       player.closeInventory();
                   }
            }

            if (Objects.requireNonNull(clickEvent.getCurrentItem()).getType().equals(Material.CRAFTING_TABLE)) {
                if (plugin.challenge.size() == 0) {
                    plugin.challenge.add(2);
                    Bukkit.broadcast(Component.text(player.getName() + " hat die Challenge 2 gestartet"));
                    player.closeInventory();
                }
            }

            if (Objects.requireNonNull(clickEvent.getCurrentItem()).getType().equals(Material.RED_DYE)) {
                if (plugin.challenge.size() == 0) {
                    return;
                }
                Bukkit.broadcast(Component.text(player.getName() + " hat die Challenge gestoppt"));
                plugin.challenge.clear();
            }

            if (Objects.requireNonNull(clickEvent.getCurrentItem()).getType().equals(Material.BARRIER)) {
                player.closeInventory();
            }
        }
    }
}
