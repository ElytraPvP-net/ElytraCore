package net.elytrapvp.elytracore.commands.staff;

import net.elytrapvp.elytracore.commands.AbstractCommand;
import net.elytrapvp.elytrapvp.chat.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Allows a player to fly.
 */
public class FlyCMD extends AbstractCommand {

    /**
     * Registers the command.
     */
    public FlyCMD() {
        super("fly", "fly", false);
    }

    /**
     * Executes the command.
     * @param sender The Command Sender.
     * @param args Arguments of the command.
     */
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;

        if(p.getAllowFlight()) {
            ChatUtils.chat(p, "&2&lFly &8- &aFlight has been disabled.");
            p.setAllowFlight(false);
            p.setFlying(false);
        }
        else {
            ChatUtils.chat(p, "&2&lFly &8- &aFlight has been enabled.");
            p.setAllowFlight(true);
            p.setFlying(true);
        }
    }
}