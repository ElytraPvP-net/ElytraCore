package net.elytrapvp.elytracore;

import net.elytrapvp.elytracore.commands.ListCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class ElytraCore extends JavaPlugin
{

    @Override
    public void onEnable()
    {

    }

    @Override
    public void onDisable()
    {

    }

    private void registerCommands()
    {
        getCommand("list").setExecutor(new ListCommand());
    }

}