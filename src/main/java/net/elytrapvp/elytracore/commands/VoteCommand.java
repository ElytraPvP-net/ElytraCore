package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytralibrary.chat.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class VoteCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        ChatUtils.chat(sender, "&2&l]&8&m---------------------------------------------------&2&l[");
        ChatUtils.centeredChat(sender, "&2&lVote");
        ChatUtils.centeredChat(sender, "  &aVote daily for vote crate keys!");
        ChatUtils.chat(sender, "");
        ChatUtils.chat(sender, "  &8» &ahttps://www.planetminecraft.com/server/elytrapvp-4338121/vote/");
        ChatUtils.chat(sender, "  &8» &ahttps://minecraftservers.org/vote/569103");
        ChatUtils.chat(sender, "");
        ChatUtils.chat(sender, "&2&l]&8&m---------------------------------------------------&2&l[");

        return true;
    }

}