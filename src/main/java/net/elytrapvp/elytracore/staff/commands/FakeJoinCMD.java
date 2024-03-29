package net.elytrapvp.elytracore.staff.commands;

import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import net.elytrapvp.elytracore.utilities.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * This class runs the fakejoin command, which broadcasts a fake join message.
 */
public class FakeJoinCMD extends AbstractCommand {

    /**
     * Creates the /fakejoin command with the permission "elytracore.fakejoin".
     */
    public FakeJoinCMD() {
        super("fakejoin", "elytracore.fakejoin", false);
    }

    /**
     * This is the code that runs when the command is sent.
     * @param sender The player (or console) that sent the command.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        Bukkit.broadcastMessage(ChatUtils.translate("&8[&a+&8] &a" + player.getName()));
    }
}
