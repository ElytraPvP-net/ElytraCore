package net.elytrapvp.elytracore;

import net.elytrapvp.elytracore.commands.GamemodeCommand;
import net.elytrapvp.elytracore.commands.InvSeeCommand;
import net.elytrapvp.elytracore.commands.ListCommand;
import net.elytrapvp.elytracore.commands.MediaCommands;
import org.bukkit.plugin.java.JavaPlugin;

public class ElytraCore extends JavaPlugin
{

    @Override
    public void onEnable()
    {
        registerCommands();
    }

    @Override
    public void onDisable()
    {

    }

    /**
     * Register commands used by the plugin.
     */
    private void registerCommands()
    {
        getCommand("discord").setExecutor(new MediaCommands());
        getCommand("ecsee").setExecutor(new InvSeeCommand());
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("gamemode0").setExecutor(new GamemodeCommand());
        getCommand("gamemode1").setExecutor(new GamemodeCommand());
        getCommand("gamemode2").setExecutor(new GamemodeCommand());
        getCommand("gamemode3").setExecutor(new GamemodeCommand());
        getCommand("invsee").setExecutor(new InvSeeCommand());
        getCommand("list").setExecutor(new ListCommand());
    }

}