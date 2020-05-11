package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytracore.chat.ElytraChat;
import net.elytrapvp.elytracore.chat.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor
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

        Player p = (Player) sender;

        switch(cmd.getName())
        {
            case "heal":
                if(!p.hasPermission("ep.heal"))
                {
                    p.sendMessage(Message.noPermission());
                   return true;
                }

                p.setHealth(p.getMaxHealth());
                ElytraChat.sendMessage(p, "&2&lHeal &8- &aYou have been healed.");

                break;

            case "feed":
                if(!p.hasPermission("ep.feed"))
                {
                    p.sendMessage(Message.noPermission());
                    return true;
                }

                p.setFoodLevel(20);
                ElytraChat.sendMessage(p, "&2&lFeed &8- &aYou have been fed.");
                break;
        }

        return true;
    }

}
