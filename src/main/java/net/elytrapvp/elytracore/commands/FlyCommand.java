package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytralibrary.chat.ChatUtils;
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
            ChatUtils.chat(sender, "&2&lError 78- &cYou must be a player to use that command.");
            return true;
        }

        // Exit if no permission.
        if(!sender.hasPermission("ep.fly"))
        {
            ChatUtils.chat(sender, "&2&lError 78- &cYou do not have access to that command.");
            return true;
        }

        Player p = (Player) sender;

        if(p.getAllowFlight())
        {
            ChatUtils.chat(p, "&2&lFly &8- &aFlight has been disabled.");
            p.setAllowFlight(false);
            p.setFlying(false);
        }
        else
        {
            ChatUtils.chat(p, "&2&lFly &8- &aFlight has been enabled.");
            p.setAllowFlight(true);
            p.setFlying(true);
        }

        return true;
    }

}
