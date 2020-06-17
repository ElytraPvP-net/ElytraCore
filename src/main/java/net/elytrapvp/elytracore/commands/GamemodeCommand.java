package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytralibrary.chat.ChatUtils;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Exit if sender isn't a player.
        if (!(sender instanceof Player)) {
            ChatUtils.chat(sender, "&2&lError &8- &cOnly a player can use that command.");
            return true;
        }

        Player p = (Player) sender;

        switch (cmd.getName())
        {
            case "gamemode":

                // Exit if no arguments
                if(args.length == 0)
                {
                    ChatUtils.chat(p, "&2&lUsage &8- &c/gamemode [gamemode]");
                    return true;
                }

                switch (args[0].toLowerCase())
                {
                    case "adventure":
                        setAdventure(p);
                        break;

                    case "creative":
                        setCreative(p);
                        break;

                    case "spectator":
                        setSpectator(p);
                        break;

                    case "survival":
                        setSurvival(p);
                        break;
                }

                break;

            case "gamemode0":
                setSurvival(p);
                break;

            case "gamemode1":
                setCreative(p);
                break;

            case "gamemode2":
                setAdventure(p);
                break;

            case "gamemode3":
                setSpectator(p);
                break;
        }

        return true;
    }

    /**
     * Set the player to adventure mode.
     * @param p Player
     */
    private void setAdventure(Player p)
    {
        // Exit if player does not have permission.
        if(!p.hasPermission("ep.gamemode.adventure"))
        {
            ChatUtils.chat(p, "&2&lError &8- &cYou do not have access to that command.");
            return;
        }

        p.setGameMode(GameMode.ADVENTURE);
        ChatUtils.chat(p, "&2&lGamemode &8- &aYou have switched to &fAdventure&a.");
    }

    /**
     * Set the player to Creative mode.
     * @param p Player
     */
    private void setCreative(Player p)
    {
        // Exit if player does not have permission.
        if(!p.hasPermission("ep.gamemode.creative"))
        {
            ChatUtils.chat(p, "&2&lError &8- &cYou do not have access to that command.");
            return;
        }

        p.setGameMode(GameMode.CREATIVE);
        ChatUtils.chat(p, "&2&lGamemode &8- &aYou have switched to &fCreative&a.");
    }

    /**
     * Set the player to spectator mode.
     * @param p Player
     */
    private void setSpectator(Player p)
    {
        // Exit if player does not have permission.
        if(!p.hasPermission("ep.gamemode.spectator"))
        {
            ChatUtils.chat(p, "&2&lError &8- &cYou do not have access to that command.");
            return;
        }

        p.setGameMode(GameMode.SPECTATOR);
        ChatUtils.chat(p, "&2&lGamemode &8- &aYou have switched to &fSpectator&a.");
    }

    /**
     * Set the player to survival mode.
     * @param p Player
     */
    private void setSurvival(Player p)
    {
        // Exit if player does not have permission.
        if(!p.hasPermission("ep.gamemode.survival"))
        {
            ChatUtils.chat(p, "&2&lError &8- &cYou do not have access to that command.");
            return;
        }

        p.setGameMode(GameMode.SURVIVAL);
        ChatUtils.chat(p, "&2&lGamemode &8- &aYou have switched to &fSurvival&a.");
    }

}