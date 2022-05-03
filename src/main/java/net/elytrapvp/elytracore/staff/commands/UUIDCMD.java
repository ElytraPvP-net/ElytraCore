package net.elytrapvp.elytracore.staff.commands;

import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import net.elytrapvp.elytracore.utilities.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;

/**
 * Gets the UUID of a player.
 */
public class UUIDCMD extends AbstractCommand {

    /**
     * Registers the Command.
     */
    public UUIDCMD() {
        super("uuid", "flamestaff.uuid", true);
    }

    /**
     * This is the code that runs when the command is sent.
     * @param sender The player (or console) that sent the command.
     * @param args The arguments of the command.
     */
    public void execute(CommandSender sender, String[] args) {
        if(args.length == 0) {
            ChatUtils.chat(sender, "&c&lUsage &8» &cUsage: /uuid [player]");
            return;
        }

        OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
        ChatUtils.chat(sender, "&aUUID of &f" + target.getName() + " &ais &f" + target.getUniqueId() + "&a.");
    }
}