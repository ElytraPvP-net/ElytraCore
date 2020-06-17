package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytralibrary.chat.ChatUtils;
import net.elytrapvp.elytralibrary.items.ItemBuilder;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class RenameCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        // Exit if sender is not a player.
        if(!(sender instanceof Player))
        {
            ChatUtils.chat(sender, "&2&lError &8- &cOnly a player can use that command.");
            return true;
        }

        Player p = (Player) sender;

        if(p.getInventory().getItemInMainHand().getType() == Material.AIR)
        {
            ChatUtils.chat(sender, "&2&lError &8- &cYou are not holding an item.");
            return true;
        }

        switch(label.toLowerCase())
        {
            case "rename":
                rename(p, args);
                break;

            case "lore":
                break;

            case "glow":
                glow(p);
                break;
        }

        return true;
    }

    // TODO: Finish Glow
    private void glow(Player p)
    {
        // Exit if player does not have permission.
        if(!p.hasPermission("ep.glow"))
        {
            ChatUtils.chat(p, "&2&lError 78- &cYou do not have access to that command.");
            return;
        }

        // Exit if hand is empty.
        if(p.getInventory().getItemInMainHand().getType() == Material.AIR)
        {
            ChatUtils.chat(p, "&2&lError &80 &cYou do not have anything in your hand.");
            return;
        }
    }

    private void lore()
    {

    }

    private void rename(Player p, String[] args)
    {
        // Exit if player does not have permission.
        if(!p.hasPermission("ep.rename"))
        {
            ChatUtils.chat(p, "&2&lError 78- &cYou do not have access to that command.");
            return;
        }

        // Exit if no arguments
        if(args.length == 0)
        {
            ChatUtils.chat(p,"&2&lUsage &8- &c/rename [name]");
            return;
        }

        String name = StringUtils.join(args, " ", 0, args.length);

        ItemStack item = p.getItemInHand();
        ItemStack renamed = new ItemBuilder(item)
                .setDisplayName(name)
                .build();
        p.setItemInHand(renamed);

        ChatUtils.chat(p, "&2&lRename &8- &aItem's name set to &f" + name + "&a.");
    }

}
