package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytracore.chat.ElytraChat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MediaCommands implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        switch (cmd.getName())
        {
            case "discord":
                ElytraChat.sendMessage(sender, "&2&lDiscord &8- &ahttp://discord.elytrapvp.net");
                break;

            case "website":
                ElytraChat.sendMessage(sender, "&2&lWebsite &80 &ahttp://www.elytrapvp.net");
                break;
        }

        return true;
    }

}