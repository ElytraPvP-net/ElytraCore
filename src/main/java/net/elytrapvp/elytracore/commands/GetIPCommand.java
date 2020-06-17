package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytralibrary.chat.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetIPCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        // Exit if no permission.
        if(!sender.hasPermission("ep.getip"))
        {
            ChatUtils.chat(sender, "&2&lError &8- &cYou do not have access to that command.");
            return true;
        }

        // Exit if no args.
        if(args.length == 0)
        {
            ChatUtils.chat(sender,"&2&lUsage &8- &c/getip [player]");
            return true;
        }

        Player p = Bukkit.getPlayer(args[0]);

        // Exit if player is not online.
        if(p == null)
        {
            ChatUtils.chat(sender, "&2&lError &8- &cThat player is not online.");
            return true;
        }

        String ip = p.getAddress().toString();
        ChatUtils.chat(sender, "&2&lIP &8- &aThe ip of &f" + p.getName() + " &ais &f" + ip + "&a.");

        return true;
    }

}
