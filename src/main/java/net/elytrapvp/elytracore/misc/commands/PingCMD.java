package net.elytrapvp.elytracore.misc.commands;

import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import net.elytrapvp.elytracore.utilities.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCMD extends AbstractCommand {

    /**
     * Creates the /ping command with no permissions.
     */
    public PingCMD() {
        super("ping", "", false);
    }

    /**
     * This is the code that runs when the command is sent.
     * @param sender The player (or console) that sent the command.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        if(args.length == 0 || !sender.hasPermission("ping.other")) {
            ChatUtils.chat(player, "&aYour ping is " + ChatUtils.getFormattedPing(player) + "&a.");
            return;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if(target == null) {
            ChatUtils.chat(sender, "&cError &8» &cThat player is not online.");
            return;
        }

        ChatUtils.chat(sender, "&a" + target.getName() + "\'s ping is " + ChatUtils.getFormattedPing(target) + "&a.");
    }
}