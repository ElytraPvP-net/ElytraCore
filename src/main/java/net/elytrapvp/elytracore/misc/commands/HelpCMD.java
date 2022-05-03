package net.elytrapvp.elytracore.misc.commands;

import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import net.elytrapvp.elytracore.utilities.commands.AbstractCommand;
import org.bukkit.command.CommandSender;

/**
 * This class runs the help command, which displays helpful information to the player.
 */
public class HelpCMD extends AbstractCommand {

    /**
     * Creates the /help command.
     */
    public HelpCMD() {
        super("help", "", true);
    }

    /**
     * This is the code that runs when the command is sent.
     * @param sender The player (or console) that sent the command.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(CommandSender sender, String[] args) {
        ChatUtils.chat(sender, "&aHelp menu is coming soon. In the mean time, ask a staff member for assistance.");
    }
}
