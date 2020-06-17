package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytralibrary.chat.ChatUtils;
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
                ChatUtils.chat(sender, "&2&lDiscord &8- &ahttp://discord.elytrapvp.net");
                break;

            case "website":
                ChatUtils.chat(sender, "&2&lWebsite &8- &ahttp://www.elytrapvp.net");
                break;
        }

        return true;
    }

}