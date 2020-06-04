package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytracore.chat.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class WorkbenchCommand implements CommandExecutor
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

        // Exit if no permission
        if(sender.hasPermission("ep." + cmd.getName()))
        {
            sender.sendMessage(Message.noPermission());
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
