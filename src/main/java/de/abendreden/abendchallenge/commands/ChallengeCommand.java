package de.abendreden.abendchallenge.commands;

import de.abendreden.abendchallenge.AbendChallenge;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class ChallengeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player) || !player.hasPermission("challenge.manage")) {
            return false;
        }
        player.openInventory(challengeInventory());
        return false;
    }

    private ItemStack buildItem(Material material, String displayName) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.displayName(Component.text(displayName));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    private Inventory challengeInventory() {
        Inventory inventory = Bukkit.createInventory(null, 9, Component.text(ChatColor.GOLD + "Challenge"));
        inventory.setItem(0, buildItem(Material.BLACK_STAINED_GLASS_PANE, ChatColor.BLACK + "NONE"));
        inventory.setItem(1, buildItem(Material.RED_TULIP, "1 Hearth"));
        inventory.setItem(2, buildItem(Material.CRAFTING_TABLE, "No CraftingTable"));
        inventory.setItem(3, buildItem(Material.BLACK_STAINED_GLASS_PANE, "Challenge 3"));
        inventory.setItem(4, buildItem(Material.BLACK_STAINED_GLASS_PANE, "Challenge 4"));
        inventory.setItem(5, buildItem(Material.BLACK_STAINED_GLASS_PANE, "Challenge 5"));
        inventory.setItem(6, buildItem(Material.BLACK_STAINED_GLASS_PANE, ChatColor.BLACK + "NONE"));
        inventory.setItem(8, buildItem(Material.BARRIER, ChatColor.RED + "Close"));
        inventory.setItem(7, buildItem(Material.RED_DYE, ChatColor.RED + "Stop"));
        return inventory;
    }
}
