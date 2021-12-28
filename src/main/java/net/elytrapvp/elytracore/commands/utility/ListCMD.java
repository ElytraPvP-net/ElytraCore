package net.elytrapvp.elytracore.commands.utility;

import net.elytrapvp.elytracore.commands.AbstractCommand;
import net.elytrapvp.elytrapvp.chat.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * List all players online in the server.
 */
public class ListCMD extends AbstractCommand {

    /**
     * Registers the command.
     */
    public ListCMD() {
        super("list", "list", true);
    }

    /**
     * Executes the command.
     * @param sender The Command Sender.
     * @param args Arguments of the command.
     */
    public void execute(CommandSender sender, String[] args) {
        String online = "  ";

        for(Player p : Bukkit.getOnlinePlayers()) {
            online += p.getDisplayName() + ", ";
        }

        ChatUtils.chat(sender, "&2&l]&8&m---------------------------------------------------&2&l[");
        ChatUtils.centeredChat(sender, "&2&lOnline Players");
        ChatUtils.chat(sender, "  &aThere are currently &f" + Bukkit.getOnlinePlayers().size() + " &aplayers online.");
        sender.sendMessage(online.substring(0, online.length() - 2));
        ChatUtils.chat(sender, "&2&l]&8&m---------------------------------------------------&2&l[");
    }
}