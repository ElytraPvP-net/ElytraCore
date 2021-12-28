package net.elytrapvp.elytracore;

import net.elytrapvp.SettingsManager;
import net.elytrapvp.elytracore.commands.AbstractCommand;
import net.elytrapvp.elytracore.listener.FoodLevelChangeListener;
import net.elytrapvp.elytracore.listener.PlayerJoinListener;
import net.elytrapvp.elytracore.listener.PlayerQuitListener;
import net.elytrapvp.elytrapvp.gui.GUIListeners;
import net.elytrapvp.elytrapvp.scoreboard.ScoreboardUpdate;
import org.bukkit.plugin.java.JavaPlugin;

public class ElytraCore extends JavaPlugin {
    private final SettingsManager settings = SettingsManager.getInstance();
    private static ElytraCore plugin;

    public void onEnable() {
        plugin = this;

        settings.setup(this);
        AbstractCommand.registerCommands(this);

        new ScoreboardUpdate().runTaskTimer(this, 20L, 20L);

        getServer().getPluginManager().registerEvents(new GUIListeners(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
        getServer().getPluginManager().registerEvents(new FoodLevelChangeListener(), this);
    }

    public void onDisable() {
        plugin = null;
    }

    public static ElytraCore getPlugin() {
        return plugin;
    }
}