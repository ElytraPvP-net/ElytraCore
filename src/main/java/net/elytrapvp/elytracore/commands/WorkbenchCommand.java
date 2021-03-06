package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytralibrary.chat.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorkbenchCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        // Exit if not a player.
        if(!(sender instanceof Player))
        {
            ChatUtils.chat(sender, "&2&lError &8- &cYou must be a player to use that command.");
           return true;
        }

        // Exit if no permission
        if(sender.hasPermission("ep." + cmd.getName()))
        {
            ChatUtils.chat(sender, "&2&lError &8- &cYou do not have access to that command.");
            return true;
        }

        Player p = (Player) sender;

        switch(cmd.getName())
        {
            case "enderchest":
                p.openInventory(p.getEnderChest());
                break;

            case "workbench":
                p.openWorkbench(p.getLocation(), true);
                break;
        }

        return true;
    }

}
