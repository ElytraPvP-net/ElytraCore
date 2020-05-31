package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytracore.chat.ElytraChat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class VoteCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        ElytraChat.sendMessage(sender, "&2&l]&8&m---------------------------------------------------&2&l[");
        ElytraChat.centeredChat(sender, "&2&lVote");
        ElytraChat.centeredChat(sender, "  &aVote daily for vote crate keys!");
        ElytraChat.sendMessage(sender, "");
        ElytraChat.sendMessage(sender, "  &8» &ahttps://www.planetminecraft.com/server/elytrapvp-4338121/vote/");
        ElytraChat.sendMessage(sender, "  &8» &ahttps://minecraftservers.org/vote/569103");
        ElytraChat.sendMessage(sender, "");
        ElytraChat.sendMessage(sender, "&2&l]&8&m---------------------------------------------------&2&l[");

        return true;
    }

}
