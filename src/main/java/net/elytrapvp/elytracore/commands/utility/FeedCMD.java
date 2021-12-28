package net.elytrapvp.elytracore.commands.utility;

import net.elytrapvp.elytracore.commands.AbstractCommand;
import net.elytrapvp.elytrapvp.chat.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Feeds the player.
 */
public class FeedCMD extends AbstractCommand {

    /**
     * Registers the command.
     */
    public FeedCMD() {
        super("feed", "feed", false);

    }

    /**
     * Executes the command.
     * @param sender The Command Sender.
     * @param args Arguments of the command.
     */
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        p.setFoodLevel(20);
        ChatUtils.chat(p, "&2&lFeed &8- &aYou have been fed.");
    }
}
