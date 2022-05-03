package net.elytrapvp.elytracore.misc.commands;

import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import net.elytrapvp.elytracore.utilities.commands.AbstractCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * This class runs the feed command, which feeds the player who ran it.
 */
public class FeedCMD extends AbstractCommand {

    /**
     * Creates the /feed command with the permission "elytracore.feed".
     */
    public FeedCMD() {
        super("feed", "elytracore.feed", false);
    }

    /**
     * This is the code that runs when the command is sent.
     * @param sender The player (or console) that sent the command.
     * @param args The arguments of the command.
     */
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        player.setFoodLevel(20);
        ChatUtils.chat(player, "&a&lFeed &8» &aYou have been fed.");
    }
}