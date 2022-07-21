package net.elytrapvp.elytracore.misc.commands;

import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import net.elytrapvp.elytracore.utilities.commands.AbstractCommand;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class DiscordCMD extends AbstractCommand {


    public DiscordCMD() {
        super("discord", "", true);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        ChatUtils.chat(player, "https://discord.gg/jy28s9cdrA");
        return;
    }


}
