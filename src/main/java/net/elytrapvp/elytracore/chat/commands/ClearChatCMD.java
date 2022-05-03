package net.elytrapvp.elytracore.chat.commands;

import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import net.elytrapvp.elytracore.utilities.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCMD extends AbstractCommand {

    public ClearChatCMD() {
        super("clearchat", "elytracore.clearchat", true);
    }

    /**
     * This is the code that runs when the command is sent.
     * @param sender The player (or console) that sent the command.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length != 0) {
            Player target = Bukkit.getPlayer(args[0]);

            if(target == null) {
                return;
            }

            for(int i = 0; i < 100; i++) {
                ChatUtils.chat(target, " ");
            }

            return;
        }

        for(Player player : Bukkit.getOnlinePlayers()) {
            for(int i = 0; i < 100; i++) {
                ChatUtils.chat(player, " ");
            }

            ChatUtils.chat(player, "&aChat was cleared by &f" + sender.getName() + "&a.");
        }
    }
}