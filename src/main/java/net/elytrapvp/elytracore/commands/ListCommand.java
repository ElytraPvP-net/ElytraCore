package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytracore.chat.ElytraChat;
import net.elytrapvp.elytracore.chat.Message;
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
            sender.sendMessage(Message.noPermission());
            return true;
        }

        String online = "  ";

        for(Player p : Bukkit.getOnlinePlayers())
        {
            online += p.getDisplayName() + ", ";
        }

        sender.sendMessage(Message.divder());
        ElytraChat.centeredChat(sender, "&2&lOnline Players");
        ElytraChat.sendMessage(sender, "  &aThere are currently &f" + Bukkit.getOnlinePlayers().size() + " &aplayers online.");
        sender.sendMessage(online.substring(0, online.length() - 2));
        sender.sendMessage(Message.divder());
        return true;
    }

}