package net.elytrapvp.elytracore.misc.commands;

import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import net.elytrapvp.elytracore.utilities.commands.AbstractCommand;
import org.bukkit.command.CommandSender;

/**
 * This class runs the rules command, which links to the server rules.
 */
public class RulesCMD extends AbstractCommand {

    /**
     * Creates the /rules command.
     */
    public RulesCMD() {
        super("rules", "", true);
    }

    /**
     * This is the code that runs when the command is sent.
     * @param sender The player (or console) that sent the command.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(CommandSender sender, String[] args) {
        ChatUtils.chat(sender, "&aView the server rules here: http://www.elytrapvp.net/rules/");
    }
}