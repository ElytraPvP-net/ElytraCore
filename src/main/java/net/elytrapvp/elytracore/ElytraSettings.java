package net.elytrapvp.elytracore;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class ElytraSettings
{
    private ElytraSettings(){}
    static ElytraSettings instance = new ElytraSettings();

    public static ElytraSettings getInstance()
    {
        return instance;
    }

    FileConfiguration config;
    File configFile;

    public void setup(Plugin pl)
    {
        config = pl.getConfig();
        config.options().copyDefaults(true);
        configFile = new File(pl.getDataFolder(), "config.yml");
        pl.saveConfig();
    }

    public FileConfiguration getConfig()
    {
        return config;
    }

    public void saveConfig()
    {
        try
        {
            config.save(configFile);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This updates the config in case changes are made.
     */
    public void reloadConfig()
    {
        saveConfig();
        config = YamlConfiguration.loadConfiguration(configFile);
    }
}
