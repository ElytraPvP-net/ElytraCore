package net.elytrapvp.elytracore.commands.utility;

import net.elytrapvp.elytracore.commands.AbstractCommand;
import net.elytrapvp.elytrapvp.chat.ChatUtils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Broadcast a message to everyone online.
 */
public class BroadcastCMD extends AbstractCommand {

    /**
     * Register command.
     */
    public BroadcastCMD() {
        super("broadcast", "broadcast", true);
    }

    /**
     * Execute command.
     * @param sender The Command Sender.
     * @param args Arguments of the command.
     */
    public void execute(CommandSender sender, String[] args) {
        if(args.length == 0) {
            ChatUtils.chat(sender, "&c&lUsage &8» /bc [message]");
            return;
        }

        for(Player p : Bukkit.getOnlinePlayers()) {
            ChatUtils.chat(p, StringUtils.join(args, " "));
        }
    }
}