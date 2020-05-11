package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytracore.chat.ElytraChat;
import net.elytrapvp.elytracore.chat.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        // Exit if not a player.
        if(!(sender instanceof Player))
        {
            sender.sendMessage(Message.notAPlayer());
            return true;
        }

        // Exit if no permission.
        if(!sender.hasPermission("ep.fly"))
        {
            sender.sendMessage(Message.noPermission());
            return true;
        }

        Player p = (Player) sender;

        if(p.getAllowFlight())
        {
            ElytraChat.sendMessage(p, "&2&lFly &8- &aFlight has been disabled.");
            p.setAllowFlight(false);
            p.setFlying(false);
        }
        else
        {
            ElytraChat.sendMessage(p, "&2&lFly &8- &aFlight has been enabled.");
            p.setAllowFlight(true);
            p.setFlying(true);
        }

        return true;
    }

}
