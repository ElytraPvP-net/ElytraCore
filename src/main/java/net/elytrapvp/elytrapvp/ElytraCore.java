package net.elytrapvp.elytrapvp;

import net.elytrapvp.elytrapvp.gui.GUIListeners;
import net.elytrapvp.elytracore.listener.FoodLevelChangeListener;
import net.elytrapvp.elytrapvp.listeners.JoinListeners;
import net.elytrapvp.elytrapvp.scoreboard.ScoreboardUpdate;
import org.bukkit.plugin.java.JavaPlugin;

public final class ElytraCore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        registerListeners();
        new ScoreboardUpdate().runTaskTimer(this, 20L, 20L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new GUIListeners(), this);
        getServer().getPluginManager().registerEvents(new JoinListeners(), this);
        getServer().getPluginManager().registerEvents(new FoodLevelChangeListener(), this);
    }
}
