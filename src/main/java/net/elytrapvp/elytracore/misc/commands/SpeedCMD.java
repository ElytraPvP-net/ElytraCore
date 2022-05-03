package net.elytrapvp.elytracore.misc.commands;

import net.elytrapvp.elytracore.utilities.chat.ChatUtils;
import net.elytrapvp.elytracore.utilities.commands.AbstractCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * This class runs the speed command, which changes the player's speed.
 */
public class SpeedCMD extends AbstractCommand {

    /**
     * Creates the /speed command with the permission "elytracore.speed".
     */
    public SpeedCMD() {
        super("speed", "elytracore.speed", false);
    }

    /**
     * This is the code that runs when the command is sent.
     * @param sender The player (or console) that sent the command.
     * @param args The arguments of the command.
     */
    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length == 0) {
            return;
        }

        try {
            int speed = Integer.parseInt(args[0]);

            Player player = (Player) sender;
            player.setFlySpeed(speed);
            player.setWalkSpeed(speed);
            ChatUtils.chat(sender, "&aYour speed has been set to &f" + speed + "&a.");
        }
        catch (NumberFormatException exception) {
            ChatUtils.chat(sender, "&c&lUsage &8» &c/speed [number]");
        }
    }
}
