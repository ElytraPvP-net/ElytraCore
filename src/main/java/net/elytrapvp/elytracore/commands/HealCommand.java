package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytralibrary.chat.ChatUtils;
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
            ChatUtils.chat(sender, "&2&lError &8- &cOnly a player can use that command.");
            return true;
        }

        Player p = (Player) sender;

        switch(cmd.getName())
        {
            case "heal":
                if(!p.hasPermission("ep.heal"))
                {
                    ChatUtils.chat(p, "&2&lError 78- &cYou do not have access to that command.");
                   return true;
                }

                p.setHealth(p.getMaxHealth());
                ChatUtils.chat(p, "&2&lHeal &8- &aYou have been healed.");

                break;

            case "feed":
                if(!p.hasPermission("ep.feed"))
                {
                    ChatUtils.chat(p, "&2&lError &8- &cYou do not have access to that command.");
                    return true;
                }

                p.setFoodLevel(20);
                ChatUtils.chat(p, "&2&lFeed &8- &aYou have been fed.");
                break;
        }

        return true;
    }

}
