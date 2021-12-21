package de.abendreden.abendchallenge;

import de.abendreden.abendchallenge.commands.ChallengeCommand;
import de.abendreden.abendchallenge.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Objects;

public class AbendChallenge extends JavaPlugin {

    public ArrayList<Integer> challenge = new ArrayList<>();

    @Override
    public void onEnable() {
        initCommands();
        initListeners();
    }

    private void initCommands() {
        Objects.requireNonNull(getCommand("challenge")).setExecutor(new ChallengeCommand());
    }

    private void initListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new EntityRegainHealthListener(this), this);
        pluginManager.registerEvents(new InventoryClickListener(this), this);
        pluginManager.registerEvents(new PlayerJoinListener(this), this);
        pluginManager.registerEvents(new PlayerRespawnListener(this), this);
        pluginManager.registerEvents(new PlayerInteractListener(this), this);

    }
}
