package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytralibrary.chat.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        // Exit if sender has no permission.
        if(!(sender.hasPermission("ep.list")))
        {
            ChatUtils.chat(sender, "&2&lError &8- &cYou do not have access to that command.");
            return true;
        }

        String online = "  ";

        for(Player p : Bukkit.getOnlinePlayers())
        {
            online += p.getDisplayName() + ", ";
        }

        ChatUtils.chat(sender, "&2&l]&8&m---------------------------------------------------&2&l[");
        ChatUtils.centeredChat(sender, "&2&lOnline Players");
        ChatUtils.chat(sender, "  &aThere are currently &f" + Bukkit.getOnlinePlayers().size() + " &aplayers online.");
        sender.sendMessage(online.substring(0, online.length() - 2));
        ChatUtils.chat(sender, "&2&l]&8&m---------------------------------------------------&2&l[");
        return true;
    }

}