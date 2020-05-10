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
        switch (label.toLowerCase())
        {
            case "discord":
                ElytraChat.sendMessage(sender, "&2&lDiscord &8- &ahttps://discord.gg/YWGFeNA");
                break;
        }

        return true;
    }

}