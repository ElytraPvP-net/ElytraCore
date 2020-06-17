package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytralibrary.chat.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UUIDCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        // Exit if sender does not have permission.
        if(!sender.hasPermission("ep.uuid"))
        {
            ChatUtils.chat(sender, "&2&LError &8- &cYou do not have access to that command.");
            return true;
        }

        // Exit if no arguments.
        if(args.length == 0)
        {
            ChatUtils.chat(sender, "&2&lUsage &8- &c/uuid [player]");
            return true;
        }

        OfflinePlayer p = Bukkit.getOfflinePlayer(args[0]);
        ChatUtils.chat(sender, "&2&lUUID &8- &f" + p.getName() + "&a's UUID is &f" + p.getUniqueId().toString() + "&a.");

        return true;
    }

}
