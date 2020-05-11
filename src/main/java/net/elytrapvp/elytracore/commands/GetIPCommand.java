package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytracore.chat.ElytraChat;
import net.elytrapvp.elytracore.chat.Message;
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
            sender.sendMessage(Message.noPermission());
            return true;
        }

        // Exit if no args.
        if(args.length == 0)
        {
            sender.sendMessage(Message.usage("/getip [player]"));
            return true;
        }

        Player p = Bukkit.getPlayer(args[0]);

        // Exit if player is not online.
        if(p == null)
        {
            sender.sendMessage(Message.notOnline());
            return true;
        }

        String ip = p.getAddress().toString();
        ElytraChat.sendMessage(sender, "&2&lIP &8- &aThe ip of &f" + p.getName() + " &ais &f" + ip + "&a.");

        return true;
    }

}
