package net.elytrapvp.elytracore;

import net.elytrapvp.elytracore.commands.*;
import net.elytrapvp.elytracore.listeners.PlayerJoinListener;
import net.elytrapvp.elytracore.listeners.PlayerQuitListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ElytraCore extends JavaPlugin
{
    private static final ElytraSettings settings = ElytraSettings.getInstance();
    private static Plugin plugin;

    @Override
    public void onEnable()
    {
        plugin = this;

        // Setup config file.
        settings.setup(this);

        // Register commands and listeners used by the plugin.
        registerCommands();
        registerListeners();
    }

    @Override
    public void onDisable()
    {
        plugin = null;
    }

    public static Plugin getPlugin()
    {
        return plugin;
    }

    /**
     * Register commands used by the plugin.
     */
    private void registerCommands()
    {
        getCommand("afk").setExecutor(new AFKCommand());
        getCommand("clearchat").setExecutor(new ClearChatCommand());
        getCommand("discord").setExecutor(new MediaCommands());
        getCommand("ecsee").setExecutor(new InvSeeCommand());
        getCommand("feed").setExecutor(new HealCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("gamemode0").setExecutor(new GamemodeCommand());
        getCommand("gamemode1").setExecutor(new GamemodeCommand());
        getCommand("gamemode2").setExecutor(new GamemodeCommand());
        getCommand("gamemode3").setExecutor(new GamemodeCommand());
        getCommand("getip").setExecutor(new GetIPCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("invsee").setExecutor(new InvSeeCommand());
        getCommand("list").setExecutor(new ListCommand());
        getCommand("pcc").setExecutor(new ClearChatCommand());
        getCommand("tpa").setExecutor(new TPRequestCommand());
        getCommand("tpaccept").setExecutor(new TPRequestCommand());
        getCommand("tpdeny").setExecutor(new TPRequestCommand());
        getCommand("uuid").setExecutor(new UUIDCommand());
    }

    private void registerListeners()
    {
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
    }

}