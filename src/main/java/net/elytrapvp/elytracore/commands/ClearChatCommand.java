package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytracore.chat.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCommand implements CommandExecutor
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

        switch(label)
        {
            case "pcc":
                playerClearChat(p);
                return true;

            case "clearchat":
                clearChat(p);
                return true;
        }

        return true;
    }

    private void clearChat(Player p)
    {
        // Exit if no permissions.
        if(!p.hasPermission("ep.clearchat"))
        {
            p.sendMessage(Message.noPermission());
            return;
        }

        for(Player pl : Bukkit.getOnlinePlayers())
        {
            playerClearChat(pl);
        }
    }

    private void playerClearChat(Player p)
    {
        for(int i = 0; i < 100; i++)
        {
            p.sendMessage("");
        }
    }

}
