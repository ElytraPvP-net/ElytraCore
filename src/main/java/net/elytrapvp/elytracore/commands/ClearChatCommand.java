package net.elytrapvp.elytracore.commands;


import net.elytrapvp.elytralibrary.chat.ChatUtils;
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
            ChatUtils.chat(sender, "&2&lError &8- &cOnly players can use that command.");
            return true;
        }

        Player p = (Player) sender;

        switch(cmd.getName())
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
            ChatUtils.chat(p, "&2&lError 78- &cYou do not have access to that command.");
            return;
        }

        for(Player pl : Bukkit.getOnlinePlayers())
        {
            playerClearChat(pl);
        }

        ChatUtils.chat(p, "&2&lChat &8- &aChat has been cleared.");
    }

    private void playerClearChat(Player p)
    {
        for(int i = 0; i < 100; i++)
        {
            p.sendMessage("");
        }
    }

}
