package net.elytrapvp.elytracore;

import net.elytrapvp.elytracore.chat.filter.FilterManager;
import net.elytrapvp.elytracore.chat.listeners.AsyncPlayerChatListener;
import net.elytrapvp.elytracore.chat.listeners.PlayerQuitListener;
import net.elytrapvp.elytracore.utilities.commands.AbstractCommand;
import net.elytrapvp.elytracore.utilities.gui.GUIListeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ElytraCore extends JavaPlugin {
    private FilterManager filterManager;
    private MySQL mySQL;
    private SettingsManager settingsManager;

    @Override
    public void onEnable() {
        settingsManager = new SettingsManager(this);

        mySQL = new MySQL(this);
        mySQL.openConnection();

        AbstractCommand.registerCommands(this);

        Bukkit.getPluginManager().registerEvents(new AsyncPlayerChatListener(this), this);
        Bukkit.getPluginManager().registerEvents(new GUIListeners(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(this), this);

        filterManager = new FilterManager();

        new ElytraCoreAPI(this);
    }

    /**
     * Get the Filter Manager, which gives us access to chat filters.
     * @return Filter Manager.
     */
    public FilterManager getFilterManager() {
        return filterManager;
    }

    /**
     * Be able to connect to MySQL.
     * @return MySQL.
     */
    public MySQL getMySQL() {
        return mySQL;
    }

    /**
     * Get the Settings Manager, which gives us access to the plugin Configuration.
     * @return Settings Manager.
     */
    public SettingsManager getSettingsManager() {
        return settingsManager;
    }
}