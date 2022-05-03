package net.elytrapvp.elytracore.chat.commands;

import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import net.elytrapvp.elytracore.utilities.commands.AbstractCommand;
import org.bukkit.command.CommandSender;

public class PersonalClearChatCMD extends AbstractCommand {

    public PersonalClearChatCMD() {
        super("personalclearchat", "", false);
    }

    /**
     * This is the code that runs when the command is sent.
     * @param sender The player (or console) that sent the command.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(CommandSender sender, String[] args) {
        for(int i = 0; i < 100; i++) {
            ChatUtils.chat(sender, " ");
        }
    }
}
