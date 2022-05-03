package net.elytrapvp.elytracore.misc.commands;

import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import net.elytrapvp.elytracore.utilities.commands.AbstractCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * This class runs the heal command, which heals the player who ran it.
 */
public class HealCMD extends AbstractCommand {

    /**
     * Creates the /heal command with the permission "elytracore.heal".
     */
    public HealCMD() {
        super("heal", "elytracore.heal", false);
    }

    /**
     * This is the code that runs when the command is sent.
     * @param sender The player (or console) that sent the command.
     * @param args The arguments of the command.
     */
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        player.setHealth(player.getMaxHealth());
        ChatUtils.chat(player, "&a&lHeal &8» &aYou have been healed.");
    }
}