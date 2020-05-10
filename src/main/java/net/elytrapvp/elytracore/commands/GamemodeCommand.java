package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytracore.chat.ElytraChat;
import net.elytrapvp.elytracore.chat.Message;
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
            sender.sendMessage(Message.notAPlayer());
            return true;
        }

        Player p = (Player) sender;

        switch (cmd.getName())
        {
            case "gamemode":

                // Exit if no arguments
                if(args.length == 0)
                {
                    p.sendMessage(Message.usage("/gamemode [gamemode]"));
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
            p.sendMessage(Message.noPermission());
            return;
        }

        p.setGameMode(GameMode.ADVENTURE);
        ElytraChat.sendMessage(p, "&2&lGamemode &8- &fYou have switched to &fAdventure&a.");
    }

    /**
     * Set the player to Creative mode.
     * @param p
     */
    private void setCreative(Player p)
    {
        // Exit if player does not have permission.
        if(!p.hasPermission("ep.gamemode.creative"))
        {
            p.sendMessage(Message.noPermission());
            return;
        }

        p.setGameMode(GameMode.CREATIVE);
        ElytraChat.sendMessage(p, "&2&lGamemode &8- &fYou have switched to &fCreative&a.");
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
            p.sendMessage(Message.noPermission());
            return;
        }

        p.setGameMode(GameMode.SPECTATOR);
        ElytraChat.sendMessage(p, "&2&lGamemode &8- &fYou have switched to &fSpectator&a.");
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
            p.sendMessage(Message.noPermission());
            return;
        }

        p.setGameMode(GameMode.SURVIVAL);
        ElytraChat.sendMessage(p, "&2&lGamemode &8- &fYou have switched to &fSurvival&a.");
    }

}