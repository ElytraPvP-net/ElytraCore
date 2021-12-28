package net.elytrapvp.elytracore.commands;

import net.elytrapvp.elytrapvp.chat.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Heals the player.
 */
public class HealCMD extends AbstractCommand {

    /**
     * Registers the command.
     */
    public HealCMD() {
        super("heal", "hea", false);
    }

    /**
     * Executes the command.
     * @param sender The Command Sender.
     * @param args Arguments of the command.
     */
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        p.setHealth(p.getMaxHealth());
        ChatUtils.chat(p, "&2&lHeal &8- &aYou have been healed.");
    }
}