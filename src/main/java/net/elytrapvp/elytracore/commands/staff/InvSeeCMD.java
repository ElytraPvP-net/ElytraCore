package net.elytrapvp.elytracore.commands.staff;

import net.elytrapvp.elytracore.commands.AbstractCommand;
import net.elytrapvp.elytrapvp.chat.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvSeeCMD extends AbstractCommand {

    /**
     * Registers the command.
     */
    public InvSeeCMD() {
        super("invsee", "invsee", false);
    }

    /**
     * Executes the command.
     * @param sender The Command Sender.
     * @param args Arguments of the command.
     */
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;

        // Exit if no arguments.
        if (args.length == 0) {
            ChatUtils.chat(p, "&c&lUsage &8» &c/invsee [player]");
            return;
        }

        Player t = Bukkit.getPlayer(args[0]);

        // Exit if player is not online.
        if (t == null) {
            ChatUtils.chat(p, "&c&lError &8» &cThat player is not online.");
            return;
        }

        p.openInventory(t.getInventory());
    }
}