package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytralibrary.chat.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class AFKCommand implements CommandExecutor
{
    public static Set<UUID> afkPlayers = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        // Exit if sender is not a player.
        if(!(sender instanceof Player))
        {
            ChatUtils.chat(sender, "&2&lError 78- &cYou must be a player to use that command.");
            return true;
        }

        Player p = (Player) sender;

        // Exit if no permission.
        if(!p.hasPermission("ep.afk"))
        {
            ChatUtils.chat(p, "&2&lError 78- &cYou do not have access to that command.");
            return false;
        }

        if(afkPlayers.contains(p.getUniqueId()))
        {
            Bukkit.broadcastMessage(ChatUtils.translate("&2&l* &f" + p.getDisplayName() + " &ais no longer afk"));
            afkPlayers.remove(p.getUniqueId());
        }
        else
        {
            Bukkit.broadcastMessage(ChatUtils.translate("&2&l* &f" + p.getDisplayName() + " &ais now afk"));
            afkPlayers.add(p.getUniqueId());
        }

        return true;
    }

    /**
     * Get all afk players.
     * @return Set of afk players.
     */
    public static Set<UUID> getAfkPlayers()
    {
        return afkPlayers;
    }

}